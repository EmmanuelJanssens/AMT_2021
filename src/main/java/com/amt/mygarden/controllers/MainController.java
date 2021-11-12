package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


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
