package com.amt.myGarden.myGarden.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class HelloWorld {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long number;
    String hello;

    public HelloWorld(String hello) {

        this.hello = hello;
    }

    public HelloWorld() {

    }
    public String sayHello(){
       return hello;
    }
}
