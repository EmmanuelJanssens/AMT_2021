package com.amt.mygarden.repository;

import org.springframework.data.repository.CrudRepository;

import com.amt.mygarden.models.Fruit;

public interface FruitRepository extends CrudRepository<Fruit, Integer>{
}
