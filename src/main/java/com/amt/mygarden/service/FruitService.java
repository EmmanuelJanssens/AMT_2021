package com.amt.mygarden.service;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.payloads.FruitRequest;
import com.amt.mygarden.payloads.MessageResponse;
import com.amt.mygarden.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    @Autowired
    FruitRepository fruitRepository;

    public MessageResponse createFruit(FruitRequest fruitRequest) {
        Fruit newFruit = new Fruit();
        newFruit.setName(fruitRequest.getName());
        return new MessageResponse("New Fruit created successfully");
    }

    // update

    // TODO throw ResourceNotFound
    public Fruit getASingleFruit(Integer fruitId) throws Exception{
        return fruitRepository.findById(fruitId).orElseThrow(() -> new Exception("fruit not found"));
    }







}
