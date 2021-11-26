package com.amt.mygarden.repository;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query("SELECT i FROM Item i where i.username = ?1")
    Iterable<Item> findUserKart(String username);
    @Query("SELECT i FROM Item i where i.username = ?1 AND i.fruit=?2")
    Optional<Item> findUserFruitAndKart(String username, Fruit fruit);

}
