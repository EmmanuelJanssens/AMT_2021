package com.amt.mygarden.controllers;

import com.amt.mygarden.repository.ItemRepository;
import com.amt.mygarden.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping(path="/cart")
public class CartController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    ServletContext context;

   @GetMapping
    public String viewItems(Model model){

        model.addAttribute("allItems",itemRepository.findUserCart("admin"));

        return "cart";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/cart";
    }


    @GetMapping(path = "/delete/all")
    public String deleteAllItems() {
        itemService.deleteAllItemsByUser("admin");
        return "redirect:/cart";
    }
}
