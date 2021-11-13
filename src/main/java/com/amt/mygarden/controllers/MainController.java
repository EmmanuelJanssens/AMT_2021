package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    CategoryRepository categories;

    @Autowired
    FruitRepository fruits;

    @GetMapping(value = "/dashboard")
    public String viewDashboard(Model model){

        model.addAttribute("fruit",new Fruit());
        model.addAttribute("allFruitCategories",categories.findAll());
        model.addAttribute("allFruits",fruits.findAll());

        return "dashboard";
    }

}
