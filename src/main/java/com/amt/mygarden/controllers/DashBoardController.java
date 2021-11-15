package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path="/dashboard")
public class DashBoardController {

    @Autowired
    CategoryRepository categories;

    @Autowired
    FruitService fruits;



    @GetMapping
    public String viewDashboard(Model model){

        model.addAttribute("allFruits",fruits.getAllFruits());
        return "dashboard";
    }

    @GetMapping(value = "/openFruitModal")
    public String openDialogBox(Model model){

        Fruit fruit = new Fruit();
        model.addAttribute("fruit",fruit);
        model.addAttribute("allFruitCategories",categories.findAll());

        return "addFruitModal";
    }
}
