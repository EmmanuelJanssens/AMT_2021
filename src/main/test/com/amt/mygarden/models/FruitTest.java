package com.amt.mygarden.models;

import com.amt.mygarden.models.Fruit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {

    Fruit apple;

    @BeforeEach
    void setUp() {
        apple = new Fruit("Apple");
    }

    @Test
    void getName() {
        assertEquals("Apple", apple.getName());
    }

    @Test
    void setName(){
        apple.setName("Banana");
        assertEquals("Banana", apple.getName());
    }
}