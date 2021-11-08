package com.amt.mygarden.models;

import org.assertj.core.util.Preconditions;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class Kart  {

    @Id
    private String token;

    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "FruitKart")
    private Map<Fruit, Integer> mapKart;

    public Kart(String token, Map<Fruit, Integer> mapKart) {
        Preconditions.checkNotNull(token);
        this.mapKart = mapKart;
    }


    public void setToken(String token) {
        this.token = token;
    }
    

    @Id
    public String getToken() {
        return token;
    }

    public Map<Fruit, Integer> getMapKart() {
        return mapKart;
    }

    public void addFruitKart(Fruit fruit){
        if(this.mapKart.containsKey(fruit)){
            this.mapKart.put(fruit,this.mapKart.get(fruit)+1);
        }else{
            this.mapKart.put(fruit, 1);
        }
    }
    public void addFruitKartWithQuantity(Fruit fruit, int quantity){
        if(this.mapKart.containsKey(fruit)){
            this.mapKart.put(fruit,this.mapKart.get(fruit)+quantity);
        }else{
            this.mapKart.put(fruit, quantity);
        }
    }
}
