package com.amt.mygarden.models;

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
        assertEqual("Banana", apple.getName());
    }
}