package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Item;
import com.amt.mygarden.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShoppingCartController {
    @Autowired
    private ItemRepository itemRepository;
/*
    @GetMapping("/cart")
    public String showShoppintCart(Model model){
        List<Item> cart=itemRepository.findUserKart("admin");// to be changed with auth
        model.addAttribute("cart",cart);
        return "cart";
    }

 */
}
