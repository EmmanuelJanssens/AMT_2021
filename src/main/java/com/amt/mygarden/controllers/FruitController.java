package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.payloads.FruitRequest;
import com.amt.mygarden.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/fruit") // This means URL's start with /demo (after Application path)
public class FruitController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private FruitRepository fruitRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewFruit (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Fruit f = new Fruit(name);
        fruitRepository.save(f);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Fruit> getAllFruits() {

        // This returns a JSON or XML with the users
        return fruitRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Fruit> getFruit(@PathVariable long id) {
        // This returns a JSON or XML with the users
        return fruitRepository.findById((int) id);
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
