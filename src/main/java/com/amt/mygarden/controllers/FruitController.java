package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.payloads.FruitRequest;
import com.amt.mygarden.repository.FruitRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller // This means that this class is a Controller
@RequestMapping(path="/fruits/")
public class FruitController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private FruitRepository fruitRepository;

    @Autowired
    ServletContext context;

    @PostMapping("/add") // Map ONLY POST Requests
    public RedirectView  addNewFruit (@ModelAttribute Fruit fruit) throws IOException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final RedirectView redirectView = new RedirectView("/dashboard",true);

        for (Fruit f:fruitRepository.findAll()
             ) {
            if(f.getDescription().equals(fruit.getDescription())){
                System.out.println("Description already exists");
            }
        }

        MultipartFile file = fruit.getImageFile();
        if(file.getOriginalFilename().isEmpty()){
            fruit.setImage("placeholder.jpg");
        }
        else{
            String upload = "/usr/local/mygarden/images/";
            File dir = new File(upload + File.separator + "fruitImages"+File.separator);
            if(!dir.exists())
                dir.mkdirs();
            FileCopyUtils.copy(file.getBytes(),new File(dir.getAbsolutePath()+File.separator+fruit.getName()+file.getOriginalFilename()));
            fruit.setImage(file.getOriginalFilename());
        }

        fruitRepository.save(fruit);
        return redirectView;
    }
    @GetMapping
    public @ResponseBody Iterable<Fruit> getAllFruits() {

        // This returns a JSON or XML with the users

        return fruitRepository.findAll();
    }
}
/*
import com.example.my_garden_app.models.Fruit;
import com.example.my_garden_app.payloads.FruitRequest;
import com.example.my_garden_app.payloads.MessageResponse;
import com.example.my_garden_app.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    FruitService fruitService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Fruit> getFruitById (@PathVariable("id") Integer id) throws Exception {
        Fruit fruit = fruitService.getASingleFruit(id);
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addFruit( @RequestBody FruitRequest fruit) {
        MessageResponse newEmployee = fruitService.createFruit(fruit);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
}
*/