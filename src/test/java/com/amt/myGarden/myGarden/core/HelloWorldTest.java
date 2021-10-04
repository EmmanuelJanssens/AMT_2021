package com.amt.myGarden.myGarden.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

        int testingNumber;

        @BeforeEach
        void setup(){
            testingNumber = 1;
        }

        @Test
        void test(){
            testingNumber++;
            Assertions.assertEquals(2 ,testingNumber);
        }

}