package com.amt.mygarden.service;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.models.Item;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.repository.FruitRepository;

import com.amt.mygarden.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
@AllArgsConstructor
public class FruitService {
    @Autowired
    FruitRepository fruitRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    private final FileStore fileStore;

    public Iterable<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    // TODO throw ResourceNotFound
    public Fruit getASingleFruit(String fruitId) throws Exception {
        return fruitRepository.findById(fruitId).orElseThrow(() -> new Exception("fruit not found"));
    }

    public Fruit AddFruit(Fruit fruit) throws IOException {

        if(fruitRepository.findFruitsByDescription(fruit.getDescription()).isPresent()){
            return fruit;
        }
        else{
            MultipartFile file = fruit.getImageFile();
            if(!file.isEmpty()){
                if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                        IMAGE_BMP.getMimeType(),
                        IMAGE_GIF.getMimeType(),
                        IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
                    throw new IllegalStateException("File updloaded is not an image");
                }

                // get file metadata
                Map<String, String> metadata = new HashMap<>();
                metadata.put("Content-Type", file.getContentType());
                metadata.put("Content-Length", String.valueOf(file.getSize()));

                // Save image in s3 bucket
                String filename = String.format("%s", UUID.randomUUID());

                try {
                    fileStore.upload(filename, Optional.of(metadata), file.getInputStream());
                } catch (IOException e) {
                    throw new IllegalStateException("Failed to upload file", e);
                }

                fruit.setImage(filename);
            }

            fruitRepository.save(fruit);
            return null;
        }

    }

    public void deleteFruit(Fruit fruit) {
        fruit.deleteCategories();
        deleteItemsContaining(fruit);
        fruitRepository.delete(fruit);

        //todo: delete fruit image
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
    public Optional<Fruit> existsByDescription(String desc){
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
