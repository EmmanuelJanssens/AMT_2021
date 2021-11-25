package com.amt.mygarden.service;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String categoryId) throws Exception {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new Exception("Category not found"));
    }
}