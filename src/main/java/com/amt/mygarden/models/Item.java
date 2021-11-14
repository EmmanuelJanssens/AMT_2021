package com.amt.mygarden.models;


import javax.persistence.*;

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

    @Override
    public String toString() {
        return "fruit=" + fruit.getName() +
                "\n price=" + fruit.getPrice() +
                "\n quantity=" + quantity;
    }
}