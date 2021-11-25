package com.amt.mygarden.repository;

import com.amt.mygarden.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.amt.mygarden.models.Fruit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends CrudRepository<Fruit, String>{

    Iterable<Fruit> findFruitsByCategoriesContaining(Category c);


    Iterable<Fruit> findFruitsByDescription(String description);
}
