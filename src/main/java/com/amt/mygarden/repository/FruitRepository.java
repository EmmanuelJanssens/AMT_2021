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



    @Query(value = "SELECT IF(fruit.description IN (SELECT description FROM fruit), true , false) AS descExsits FROM fruit where fruit.description = '?1'",nativeQuery = true)
    boolean descriptionExists(String fruit);

    boolean existsByDescription(String description);
}
