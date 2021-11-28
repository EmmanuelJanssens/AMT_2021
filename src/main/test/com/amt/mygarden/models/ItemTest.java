package com.amt.mygarden.models;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ItemTest {
    private Item kart;
    private Fruit banana;
    private Fruit orange;


    @BeforeEach
    void setUp() {
        banana=new Fruit("banana");
        orange=new Fruit("orange");
        kart=new Item("1119840",banana,1);
    }
    @Test
    void testGetUsernameSuccess(){
        assertEquals("1119840", kart.getUsername());
    }
    @Test
    void testGetUsernameFailure(){
        assertNotEquals("1119841", kart.getUsername());
    }
    @Test
    void testGetFruitSuccess(){
        assertEquals(banana, kart.getFruit());
    }
    @Test
    void testGetFruitFailure(){
        assertNotEquals(orange, kart.getFruit());
    }

    @Test
    void testGetQuantitySuccess(){
        assertEquals(1, kart.getQuantity());
    }
    @Test
    void testGetQuantityFailure(){
        assertNotEquals(2, kart.getQuantity());
    }

    @Test
    void testAddSeveralFruitSuccess(){
        kart.addSeveralFruit(2);
        assertEquals(3, kart.getQuantity());
    }
    @Test
    void testAddSeveralFruitFailure(){
        kart.addSeveralFruit(2);
        assertNotEquals(4, kart.getQuantity());
    }
}
