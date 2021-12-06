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

    public Item manageCartQuantity(String fruitId, int quantity, String username) {
        Item item;
            Optional<Item> it = itemRepository.findUserFruitAndCart(username, fruitRepository.findById(fruitId).get());
            if (it.isPresent()) {
                item = it.get();
                item.addSeveralFruit(quantity);
                itemRepository.save(item);

            } else {
                item = new Item(username, fruitRepository.findById(fruitId).get(), quantity);
                itemRepository.save(item);
            }


        return item;
    }

    public void addToCart(String fruitId, int quantity, String username) {
        manageCartQuantity(fruitId, quantity, username);
    }

    public void removeFromCart(String fruitId, int quantity, String username) {
        Item item = manageCartQuantity(fruitId, -quantity,username);
        if (item.getQuantity() < 1) {
            deleteItemById(item.getId());
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

