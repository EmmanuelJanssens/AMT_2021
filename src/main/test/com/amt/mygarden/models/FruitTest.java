package com.amt.mygarden.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {

    Fruit apple;

    @BeforeEach
    void setUp() {
        apple = new Fruit();
        apple.setName("Apple");
        apple.setId(0);
    }

    @Test
    void getId() {
        assertEquals(0, apple.getId());
    }

    @Test
    void setId() {
        apple.setId(1);
        assertEquals(1, apple.getId());
    }

    @Test
    void getName() {
        assertEquals("Apple", apple.getName());
    }

    @Test
    void setName() {
        apple.setName("Pomme");
        assertEquals("Pomme", apple.getName());
    }
}