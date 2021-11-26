package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;

import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.service.CategoryService;
import com.amt.mygarden.service.FruitService;

import com.amt.mygarden.service.ItemService;
import io.micrometer.core.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.ServletContext;
import java.io.IOException;

import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
        redirect = new ModelAndView("redirect:/dashboard",model);
        return redirect;
    }

    @GetMapping
    public String viewFruits(Model model){
        model.addAttribute("allFruits",fruitService.getAllFruits());
        model.addAttribute("categories", categoryService.getAllCategories());
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
    public String addFruitsToCart(@PathVariable String id, @RequestParam(defaultValue = "1") int quantity) {
        itemService.addToCart(id, quantity);
        fruitService.removeQuantity(id);
        return "redirect:/cart";
    }
    @GetMapping(path = "/delete/{id}")
    public String deleteFruit(@PathVariable String id) {
        fruitService.deleteFruitById(id);
        return "redirect:/fruits";
    }
}
