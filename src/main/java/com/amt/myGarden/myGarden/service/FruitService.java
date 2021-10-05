package com.amt.myGarden.myGarden.service;

import com.amt.myGarden.myGarden.models.Fruit;
import com.amt.myGarden.myGarden.payloads.FruitRequest;
import com.amt.myGarden.myGarden.payloads.MessageResponse;
import com.amt.myGarden.myGarden.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
