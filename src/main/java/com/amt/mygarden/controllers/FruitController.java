package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.service.CategoryService;
import com.amt.mygarden.service.FruitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.ServletContext;
import java.io.IOException;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller // This means that this class is a Controller
@RequestMapping(path="/fruits") // This means URL's start with /demo (after Application path)
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ServletContext context;

    @PostMapping // Map ONLY POST Requests
    public RedirectView addNewFruit (@ModelAttribute Fruit fruit) throws IOException {

        final RedirectView redirectView = new RedirectView("/dashboard",true);
        fruitService.AddFruit(fruit);
        return redirectView;
    }

    @GetMapping
    public String viewFruits(Model model){
        model.addAttribute("allFruits",fruitService.getAllFruits());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "fruits";
    }

    @GetMapping(path="/{id}")
    public String getFruit(@PathVariable String id, Model model) throws Exception {
        model.addAttribute("fruit",fruitService.getASingleFruit(id));
        return "fruit";
    }
}
