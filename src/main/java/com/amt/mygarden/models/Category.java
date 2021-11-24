package com.amt.mygarden.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    private String name;

    public Category(){}


    @ManyToMany(mappedBy = "categories")
    private Set<Fruit> fruits = new HashSet<>();

}
