package com.amt.mygarden.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Category {
    @Id
    private String name;
    //@ManyToMany(mappedBy = "categories")
    //private Set<Fruit> fruitsFromThisCategories = new HashSet<>();

    public Category(){}


}
