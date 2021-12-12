package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Optional;

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
        redirect = new ModelAndView("redirect:/admin/categoryDashboard", model);
        return redirect;
    }

    @GetMapping(path = "used")
    public Iterable<Category> getUsedCategories() {
        return categories.findDistinctByFruitsNotNull();
    }

    @GetMapping(path = "/name/{value}")
    public @ResponseBody
    ResponseEntity descriptionAlreadyExists(@PathVariable(name="value") String value, HttpServletResponse response)
    {
        Optional<Category> result = categoryService.existsByName(value);

        if(result.isPresent()){
            Category cat = new Category();
            cat.setName(result.get().getName());
            return new ResponseEntity(cat, HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
