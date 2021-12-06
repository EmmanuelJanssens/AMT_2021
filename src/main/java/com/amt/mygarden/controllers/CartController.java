package com.amt.mygarden.controllers;

import com.amt.mygarden.repository.ItemRepository;
import com.amt.mygarden.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
    public String viewItems(Model model, HttpServletRequest request){
        model.addAttribute("allItems",itemRepository.findUserCart(request.getSession().getId()));

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
