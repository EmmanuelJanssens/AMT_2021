package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class AddSpecificFruitController {


        @Autowired // This means to get the bean called userRepository
        // Which is auto-generated by Spring, we will use it to handle the data
        private FruitRepository fruitRepository;

        @PostMapping(path="/add") // Map ONLY POST Requests
        public @ResponseBody
        String addNewFruit (@RequestParam String name) {
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

}
