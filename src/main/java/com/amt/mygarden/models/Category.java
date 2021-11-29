package com.amt.mygarden.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    private String name;

    public Category(){}

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "categories", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Fruit> fruits = new HashSet<>();
}
