package com.amt.mygarden.service;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    public Category AddCategory(Category category) throws IOException {

        if (categoryRepository.findCategoryByName(category.getName()) != null) {
            return category;
        } else {
            categoryRepository.save(category);
            return null;
        }

    }

    public void deleteCategoryById(String id) {
        Category category;
        try {
            category = getCategoryById(id);
        } catch (Exception e) {
            return;
        }
        category.deleteFruits();
        categoryRepository.delete(category);
    }

    public Iterable<Category> getAllUsedCategories() {
        return categoryRepository.findDistinctByFruitsNotNull();
    }

    public Iterable<Category> existsByName(String name){
        return categoryRepository.findCategoriesByName(name);
    }

}
