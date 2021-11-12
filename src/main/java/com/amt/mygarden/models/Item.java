package com.amt.mygarden.models;

import org.assertj.core.util.Preconditions;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    @OneToOne
    private Fruit fruit;

private int quantity;

    public Item(String username, Fruit fruit, int quantity) {
        this.username=username;
       this.fruit=fruit;
       this.quantity=quantity;
    }

    public Item() {

    }


    public String getUsername() {
        return username;
    }

    public int getQuantity() {
        return quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void addSeveralFruit(int quantity){
        this.quantity+=quantity;
    }
    public void addUniqueFruit(){
        this.quantity+=1;
    }

}
