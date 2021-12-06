package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoryDashboard")
public class CategoryDashBoardController {

    @Autowired
    CategoryRepository categories;

    @GetMapping
    public String viewCategoryDashboard(Model model){

        model.addAttribute("allCategories",categories.findAll());
        return "categoryDashboard";
    }

    @GetMapping(value = "/add")
    public String openCategoryForm(Model model){

        Category category = new Category();
        model.addAttribute("category",category);

        return "addCategory";
    }
}
