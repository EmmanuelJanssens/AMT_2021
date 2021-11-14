package com.amt.mygarden.controllers;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.models.Item;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.repository.FruitRepository;
import com.amt.mygarden.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fruits")
public class FruitController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private FruitRepository fruitRepository;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    ServletContext context;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewFruit (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Fruit f = new Fruit(name);
        fruitRepository.save(f);
        return "Saved";
    }

    @GetMapping
    public String viewFruits(Model model){

        model.addAttribute("allFruits",fruitRepository.findAll());

        return "fruits";
    }

    @GetMapping(path="/{id}")
    public String getFruit(@PathVariable String id, Model model) {
      model.addAttribute("f",fruitRepository.findById(id));
      return "fruit";
    }
    @PostMapping(path="/{id}")
    public RedirectView addFruitToCart (@PathVariable String id,@ModelAttribute String fruitAmount) throws IOException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final RedirectView redirectView = new RedirectView("/", true);

        Optional<Item> it=itemRepository.findUserFruitAndKart("admin",fruitRepository.findById(id).get());
        if(it.isPresent()){
           Item item1=it.get();
            item1.addSeveralFruit(Integer.valueOf(fruitAmount));
            itemRepository.save(item1);

        }else {
            Item item=new Item("admin",fruitRepository.findById(id).get(), Integer.valueOf(fruitAmount));
            itemRepository.save(item);
        }

        return redirectView;
    }
    @GetMapping(path = "/category/{category}")
    public @ResponseBody Iterable<Fruit> getCategoryFruits(@PathVariable String category){
        return fruitRepository.findFruitsByCategoriesContaining(categoryRepository.findCategoryByName(category));
    }
}
