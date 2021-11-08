package com.amt.mygarden.controllers;

import com.amt.mygarden.repository.FruitRepository;
import com.amt.mygarden.repository.KartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fruit")
public class AddFruitGeneralController {
    @Autowired
    private KartRepository kartRepository;



}
