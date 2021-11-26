package com.amt.mygarden.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;
    Fruit fruit1;
    Fruit fruit2;

    @BeforeEach
    void setUp(){

         category = new Category();
         category.setName("cat1");

        fruit1 = new Fruit();
        fruit2 = new Fruit();
        fruit1.addCategory(category);
        fruit2.addCategory(category);

    }

    @Test
    void getName() {
        assertEquals("cat1",category.getName());
    }

    @Test
    void getFruits() {
        Set<Fruit> fruits = category.getFruits();
        for(Fruit f : fruits){
            assertTrue(category.getFruits().contains(f));
        }
    }

    @Test
    void setName() {
        category.setName("cat2");
        assertEquals("cat2",category.getName());
    }

    @Test
    void setFruits() {
        Set<Fruit> set = new HashSet<>();
        set.add(fruit1);
        set.add(fruit2);
        category.setFruits(set);
        assertEquals(set, category.getFruits());
        for (Fruit f : category.getFruits()){
            assertTrue(f.getCategories().contains(category));
        }
    }
}
