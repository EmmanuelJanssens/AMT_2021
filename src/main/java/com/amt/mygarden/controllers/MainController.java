package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping(value = "/dashboard")
    public String viewDashboard(Model model){

        model.addAttribute("fruit",new Fruit());
        return "dashboard";
    }}
