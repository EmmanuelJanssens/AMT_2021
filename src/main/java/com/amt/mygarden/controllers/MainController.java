package com.amt.mygarden.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import javax.mvc.Controller;

@Controller
public class MainController {

    @GetMapping(value = "/dashboard")
    public String loadDashboard(){
        return "dashboard";
    }
}
