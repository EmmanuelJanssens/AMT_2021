package com.amt.mygarden.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Fruit(String name) {
        if(name.isEmpty())
            throw new IllegalArgumentException();

        setName(name);
    }

    private Fruit() {
        //ORM
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
