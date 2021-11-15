package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.service.FruitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller // This means that this class is a Controller
@RequestMapping(path="/fruits") // This means URL's start with /demo (after Application path)
public class FruitController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private FruitService fruitService;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CategoryRepository categoryRepository;

    @PostMapping // Map ONLY POST Requests
    public RedirectView addNewFruit (@ModelAttribute Fruit fruit) throws IOException {

        final RedirectView redirectView = new RedirectView("/dashboard",true);
        fruitService.AddFruit(fruit);
        return redirectView;
    }

    @GetMapping("description/{value}")
    public ResponseEntity<Boolean> descriptionAlreadyExists(@PathVariable String value)
    {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( fruitService.existsByDescription(value));
    }

    @GetMapping
    public @ResponseBody Iterable<Fruit> getAllFruits() {

        // This returns a JSON or XML with the users
        return fruitService.getAllFruits();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Fruit getFruit(@PathVariable String id) throws Exception {
        return fruitService.getASingleFruit(id);
    }

    @GetMapping(path = "/category/{category}")
    public @ResponseBody Iterable<Fruit> getCategoryFruits(@PathVariable String category){
        return fruitService.getFruitsByCategory(category);
    }
}
