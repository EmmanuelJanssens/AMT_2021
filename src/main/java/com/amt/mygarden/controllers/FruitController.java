package com.amt.mygarden.controllers;

import com.amt.mygarden.exceptions.FruitNotFoundException;
import com.amt.mygarden.models.Fruit;

import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.service.CategoryService;
import com.amt.mygarden.service.FruitService;

import com.amt.mygarden.service.ItemService;
import io.micrometer.core.lang.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller // This means that this class is a Controller
@RequestMapping(path="/fruits") // This means URL's start with /demo (after Application path)
public class FruitController {

    private Logger logger;


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

    public FruitController(){
        logger = LoggerFactory.getLogger(getClass());
    }
    @PostMapping // Map ONLY POST Requests
    public ModelAndView addNewFruit (@ModelAttribute Fruit fruit, ModelMap model) throws Exception {

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
        return "redirect:/cart";
    }
    @GetMapping(path = "/delete/{id}")
    public String deleteFruit(@PathVariable String id) {
        fruitService.deleteFruitById(id);
        return "redirect:/fruits";
    }

    @DeleteMapping(path = "/{id}/remove-from-cart")
    public String removeFruitFromCart(@PathVariable String id, @RequestParam(defaultValue = "1") int quantity) {
        itemService.removeFromCart(id, quantity);
        return "redirect:/cart";
    }


    @ExceptionHandler(FruitNotFoundException.class)
    public ModelAndView handleNotFound(HttpServletRequest req, FruitNotFoundException exception)throws Exception{

        if (AnnotationUtils.findAnnotation(exception.getClass(),
                ResponseStatus.class) != null)
            throw exception;

        logger.error("Request: " + req.getRequestURI() + " raised " + exception);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("timestamp", new Date().toString());
        mav.addObject("status", 404);

        mav.setViewName("support");
        return mav;
    }
}
