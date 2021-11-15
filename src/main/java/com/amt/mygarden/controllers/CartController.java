package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.models.Item;
import com.amt.mygarden.repository.FruitRepository;
import com.amt.mygarden.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;

@RestController
public class CartController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    ServletContext context;


    @GetMapping(path = "/cart")
    public String viewItems(Model model){

        model.addAttribute("allItems",itemRepository.findUserKart("admin"));

        return "cart";
    }
}
