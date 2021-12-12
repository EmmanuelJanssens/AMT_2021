package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;

import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.service.CategoryService;
import com.amt.mygarden.service.FruitService;

import com.amt.mygarden.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // This means that this class is a Controller
@RequestMapping(path="/fruits") // This means URL's start with /demo (after Application path)
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @Autowired
    private CategoryRepository categories;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ItemService itemService;

    @Autowired
    ServletContext context;

    @PostMapping // Map ONLY POST Requests
    public ModelAndView addNewFruit (@ModelAttribute Fruit fruit, ModelMap model) throws IOException {

        ModelAndView redirect;
        if(fruitService.AddFruit(fruit) == null)
        {
            model.addAttribute("allFruits",fruitService.getAllFruits());
        }
        else{
            model.addAttribute("fruit",fruit);
            model.addAttribute("allFruitCategories",categories.findAll());
        }
        redirect = new ModelAndView("redirect:/admin/dashboard",model);
        return redirect;
    }

    @GetMapping
    public String viewFruits(Model model){
        model.addAttribute("allFruits",fruitService.getAllFruits());
        model.addAttribute("categories", categoryService.getAllUsedCategories());
        return "fruits";
    }

    @GetMapping(path = "/description/{value}")
    public @ResponseBody Iterable<Fruit> descriptionAlreadyExists(@PathVariable(name="value") String value)
    {
        return fruitService.existsByDescription(value);
    }

    @GetMapping(path="/{id}")
    public String getFruit(@PathVariable String id, Model model) throws Exception {
        model.addAttribute("fruit", fruitService.getASingleFruit(id));
        return "fruit";
    }
    @PostMapping(path = "/{id}/add-to-cart")
    public String addFruitsToCart(@PathVariable String id, @RequestParam(defaultValue = "1") int quantity, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String user = request.getSession().getId();
        if (principal != null) {
            user = principal.getName();
        }

        itemService.addToCart(id, quantity, user);

        return "redirect:/cart";
    }
    @GetMapping(path = "/delete/{id}")
    public String deleteFruit(@PathVariable String id) {
        fruitService.deleteFruitById(id);
        return "redirect:/fruits";
    }

    @DeleteMapping(path = "/{id}/remove-from-cart")
    public String removeFruitFromCart(@PathVariable String id, @RequestParam(defaultValue = "1") int quantity, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String user = request.getSession().getId();
        if (principal != null) {
            user = principal.getName();
        }

        itemService.removeFromCart(id, quantity, user);
        return "redirect:/cart";
    }
}
