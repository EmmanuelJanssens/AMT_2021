package com.amt.mygarden.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Fruit {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    @Id
    private String name;
    private float price;
    private int quantity;
    @ManyToMany
    private Set<Category> categories = new HashSet<>();
    private String image;

    public Fruit(String name) {
        if(name.isEmpty())
            throw new IllegalArgumentException();

        setName(name);
    }

    public Fruit() {}

    public void addCategory(Category c){
        this.categories.add(c);
    }
}
