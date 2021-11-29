package com.amt.mygarden.models;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.models.Fruit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {

    Fruit fruit;
    Category category1;
    Category category2;


    @BeforeEach
    void setUp() {
        fruit = new Fruit("Fruit");
        category1 = new Category();
        category1.setName("cat1");
        category2 = new Category();
        fruit.addCategory(category1);
        fruit.addCategory(category2);
        category2.setName("cat2");
        fruit.setPrice(42);
        fruit.setQuantity(42);
        fruit.setDescription("test");
        fruit.setImage("imageUrl");
    }

    @Test
    void getName() {
        assertEquals("Fruit", fruit.getName());
    }

    @Test
    void setName() {
        fruit.setName("Banana");
        assertEquals("Banana", fruit.getName());
    }

    @Test
    void addCategory() {
        Category category = new Category();
        category.setName("Test");
        fruit.addCategory(category);
        assertTrue(fruit.getCategories().contains(category));
        assertTrue(category.getFruits().contains(fruit));
    }

    @Test
    void deleteCategory() {
        fruit.deleteCategory(category1);
        assertFalse(fruit.getCategories().contains(category1));
        assertFalse(category1.getFruits().contains(fruit));
    }

    @Test
    void deleteCategories() {
        fruit.deleteCategories();
        assertTrue(fruit.getCategories().isEmpty());
        assertFalse(category1.getFruits().contains(fruit));
        assertFalse(category2.getFruits().contains(fruit));
    }

    @Test
    void getPrice() {
        assertEquals(42, fruit.getPrice());
    }

    @Test
    void getQuantity() {
        assertEquals(42, fruit.getQuantity());
    }

    @Test
    void getCategories() {
        Set<Category> set = new HashSet<>();
        set.add(category1);
        set.add(category2);
        assertEquals(set, fruit.getCategories());
    }

    @Test
    void getDescription() {
        assertEquals("test", fruit.getDescription());
    }

    @Test
    void getImage(){
        assertEquals("imageUrl", fruit.getImage());
    }

    @Test
    void setPrice() {
        fruit.setPrice(12);
        assertEquals(12, fruit.getPrice());
    }

    @Test
    void setQuantity() {
        fruit.setQuantity(12);
        assertEquals(12, fruit.getQuantity());
    }

    @Test
    void setCategories() {
        Set<Category> set = new HashSet<>();
        set.add(category1);
        fruit.setCategories(set);
        assertEquals(set, fruit.getCategories());
    }

    @Test
    void setDescription() {
        fruit.setDescription("test2");
        assertEquals("test2", fruit.getDescription());
    }

    @Test
    void setImage(){
        fruit.setImage("imageURl2");
        assertEquals("imageURl2", fruit.getImage());
    }

    @Test
    void testEquals() {
        assertEquals(fruit, fruit);
    }
}
