package com.amt.mygarden.repository;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.models.Fruit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {

    Category findCategoryByName(String s);

    Iterable<Category> findDistinctByFruitsNotNull();

    Optional<Category> findCategoriesByName(String name);

}
