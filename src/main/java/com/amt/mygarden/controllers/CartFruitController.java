package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Item;
import com.amt.mygarden.repository.FruitRepository;
import com.amt.mygarden.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/carts/{cartId}/fruits")
public class CartFruitController {
    @Autowired
    private FruitRepository fruitRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(path="/{fruitId}")
    public RedirectView addFruitToCart (@PathVariable String fruitId, @ModelAttribute String fruitAmount) throws IOException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final RedirectView redirectView = new RedirectView("/", true);

        Optional<Item> it=itemRepository.findUserFruitAndCart("admin",fruitRepository.findById(fruitId).get());
        if(it.isPresent()){
            Item item1=it.get();
            item1.addSeveralFruit(Integer.valueOf(fruitAmount));
            itemRepository.save(item1);

        }else {
            Item item=new Item("admin",fruitRepository.findById(fruitId).get(), Integer.valueOf(fruitAmount));
            itemRepository.save(item);
        }

        return redirectView;
    }
}
