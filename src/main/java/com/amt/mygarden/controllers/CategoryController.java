package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/category") // This means URL's start with /demo (after Application path)
public class CategoryController {

    @Autowired
    private CategoryRepository categories;
    @Autowired
    private CategoryService categoryService;

    @PostMapping // Map ONLY POST Requests
    public ModelAndView addNewCategory(@ModelAttribute Category category, ModelMap model) throws IOException {

        ModelAndView redirect;
        if (categoryService.AddCategory(category) == null) {
            model.addAttribute("allCategories", categoryService.getAllCategories());
        } else {
            model.addAttribute("category", category);
        }
        redirect = new ModelAndView("redirect:/categoryDashboard", model);
        return redirect;
    }

    @GetMapping(path = "used")
    public Iterable<Category> getUsedCategories() {
        return categories.findDistinctByFruitsNotNull();
    }
}
