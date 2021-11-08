package com.amt.mygarden.models;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.models.Kart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class KartTest {
    private Kart kart;

    @BeforeEach
    void setUp() {
        kart=new Kart("token1", new TreeMap<Fruit, Integer>());
    }
    @Test
    void testAddSingleFruitSuccess(){
        Fruit fruit= new Fruit("Banana");
        kart.addFruitKart(fruit);
        Map<Fruit, Integer> map= new TreeMap<>();
        map.put(fruit, 1);
        System.out.println(map);
        assertEquals(map, kart.getMapKart());
    }
    @Test
    void testAddSingleFruitFailure(){
        Fruit fruit= new Fruit("Banana");
        Fruit fruit1=new Fruit("Strawberry");
        kart.addFruitKart(fruit);
        Map<Fruit, Integer> map= new TreeMap<>();
        map.put(fruit1, 1);
        assertEquals(map, kart.getMapKart());
    }
    @Test
    void testAddMultipleFruitsSuccess(){
        Fruit fruit= new Fruit("Banana");
        kart.addFruitKartWithQuantity(fruit,3);
        Map<Fruit, Integer> map= new TreeMap<>();
        map.put(fruit, 3);
        assertEquals(map, kart.getMapKart());
    }
    @Test
    void testAddMultipleFruitsFailure(){
        Fruit fruit= new Fruit("Banana");
        Fruit fruit1=new Fruit("Strawberry");
        kart.addFruitKartWithQuantity(fruit,3);
        Map<Fruit, Integer> map= new TreeMap<>();
        map.put(fruit1, 3);
        assertEquals(map, kart.getMapKart());
    }

}