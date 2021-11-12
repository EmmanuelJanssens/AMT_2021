package com.amt.mygarden.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Fruit(String name) {
        if(name.isEmpty())
            throw new IllegalArgumentException();

        setName(name);
    }


    public Fruit() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Fruit fruit){return this.id.compareTo(fruit.id);}
}

