package com.amt.mygarden.controllers;

import com.amt.mygarden.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping(path="/cart")
public class CartController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    ServletContext context;

   @GetMapping
    public String viewItems(Model model){

        model.addAttribute("allItems",itemRepository.findUserKart("admin"));

        return "cart";
    }
}
