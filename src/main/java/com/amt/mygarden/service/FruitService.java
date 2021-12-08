package com.amt.mygarden.service;

import com.amt.mygarden.exceptions.FruitNotFoundException;
import com.amt.mygarden.models.Category;
import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.models.Item;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.repository.FruitRepository;

import com.amt.mygarden.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class FruitService {
    @Autowired
    FruitRepository fruitRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    public Iterable<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    // TODO throw ResourceNotFound
    public Fruit getASingleFruit(String fruitId) throws Exception {
        return fruitRepository.findById(fruitId).orElseThrow(() -> new FruitNotFoundException("fruit not found"));
    }

    public Fruit AddFruit(Fruit fruit) throws IOException {

        if(fruitRepository.findFruitsByDescription(fruit.getDescription()).iterator().hasNext()){
            return fruit;
        }
        else{
            MultipartFile file = fruit.getImageFile();
            if(file.getOriginalFilename().isEmpty()){
                fruit.setImage("placeholder.jpg");
            }
            else{
                String upload = "/usr/local/mygarden/images/";
                File dir = new File(upload + File.separator + "fruitImages"+File.separator);
                if(!dir.exists())
                    dir.mkdirs();
                FileCopyUtils.copy(file.getBytes(),new File(dir.getAbsolutePath()+File.separator+fruit.getName()+file.getOriginalFilename()));
                fruit.setImage(fruit.getName()+file.getOriginalFilename());
            }

            fruitRepository.save(fruit);
            return null;
        }

    }

    public void deleteFruit(Fruit fruit) {
        fruit.deleteCategories();
        deleteItemsContaining(fruit);
        fruitRepository.delete(fruit);
    }

    public void deleteFruitById(String id) {
        Fruit fruit;
        try {
            fruit = getASingleFruit(id);
        } catch (Exception e) {
            return;
        }
        fruit.deleteCategories();
        //could also make the item empty
        deleteItemsContaining(fruit);
        fruitRepository.delete(fruit);
    }

    public Iterable<Fruit> getFruitsByCategory(String category) {
        return fruitRepository.findFruitsByCategoriesContaining(categoryRepository.findCategoryByName(category));
    }
    public Iterable<Fruit> existsByDescription(String desc){
        return fruitRepository.findFruitsByDescription(desc);
    }
    public void removeQuantity(String id) {
        Optional<Fruit> opt = fruitRepository.findById(id);
        if (opt.isPresent()) {
            Fruit fruit = opt.get();
            fruit.removeQuantity();
            fruitRepository.save(fruit);
        }
    }
    public void deleteItemsContaining(Fruit fruit){
        for (Item item : itemRepository.findAll()){
            if(item.getFruit().equals(fruit)){
                itemRepository.delete(item);
            }
        }
    }
}
