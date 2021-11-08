package com.amt.mygarden.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping(value = "/dashboard")
    public String loadDashboard(){
        return "dashboard";
    }
}
