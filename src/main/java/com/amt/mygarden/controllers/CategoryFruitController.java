package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.FruitRepository;
import com.amt.mygarden.service.CategoryService;
import com.amt.mygarden.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories/{categoryId}/fruits")
public class CategoryFruitController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FruitRepository fruitRepository;

    @GetMapping
    public String getCategoryFruits(@PathVariable String categoryId, Model model) throws Exception {
        Category category = categoryService.getCategoryById(categoryId);
        model.addAttribute("allFruits", fruitRepository.findFruitsByCategoriesContaining(category));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "fruits";
    }
}
