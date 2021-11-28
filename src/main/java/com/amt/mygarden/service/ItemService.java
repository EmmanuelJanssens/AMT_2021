package com.amt.mygarden.service;

import com.amt.mygarden.models.Item;
import com.amt.mygarden.repository.FruitRepository;
import com.amt.mygarden.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    FruitRepository fruitRepository;

    public void addToCart(String fruitId, int quantity) {
        Optional<Item> it = itemRepository.findUserFruitAndCart("admin", fruitRepository.findById(fruitId).get());
        if (it.isPresent()) {
            Item item1 = it.get();
            item1.addSeveralFruit(quantity);
            itemRepository.save(item1);

        } else {
            Item item = new Item("admin", fruitRepository.findById(fruitId).get(), quantity);
            itemRepository.save(item);
        }
    }

    public void deleteItemById(Long id) {

        Item itemToDelete = null;
        try {
            itemToDelete = itemRepository.findById(id).orElseThrow(() -> new Exception("item not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert itemToDelete != null;
        itemRepository.delete(itemToDelete);
    }

    // by user?
    public void deleteAllItemsByUser(String user){
        Iterable<Item> itemsToDelete = itemRepository.findUserCart(user);
        for(Item i : itemsToDelete){
            deleteItemById(i.getId());
        }
    }


}

