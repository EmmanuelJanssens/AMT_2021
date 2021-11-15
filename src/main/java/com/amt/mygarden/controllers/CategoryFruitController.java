package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories/{categoryId}/fruits")
public class CategoryFruitController {
    @Autowired
    private FruitService fruitService;

    @GetMapping
    public @ResponseBody
    Iterable<Fruit> getCategoryFruits(@PathVariable String categoryId){
        return fruitService.getFruitsByCategory(categoryId);
    }
}
