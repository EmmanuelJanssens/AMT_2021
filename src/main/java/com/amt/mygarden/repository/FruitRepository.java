package com.amt.mygarden.repository;

import org.springframework.data.repository.CrudRepository;

import com.amt.mygarden.models.Fruit;
import org.springframework.stereotype.Repository;

@Repository
    public interface FruitRepository extends CrudRepository<Fruit, String>{
}
