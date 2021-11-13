package com.amt.mygarden.models;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Fruit {

    @Id
    private String name;
    private float price;
    private int quantity;
    @ManyToMany
    private Set<Category> categories = new HashSet<>();
    private String image;
    private String description;
    @Transient
    MultipartFile imageFile;

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
