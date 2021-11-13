package com.amt.mygarden;

import com.amt.mygarden.models.Category;
import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.CategoryRepository;
import com.amt.mygarden.repository.FruitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class MyGardenAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(MyGardenAppApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(FruitRepository fruitRepository, CategoryRepository categoryRepository) throws Exception {
        return (String[] args) -> {

            // Categories
            Category c1 = new Category();
            Category c2 = new Category();
            Category c3 = new Category();
            c1.setName("Exotic");
            c2.setName("Citrus");
            c3.setName("Berry");
            categoryRepository.save(c1);
            categoryRepository.save(c2);
            categoryRepository.save(c3);

            // Fruits
            Fruit f1 = new Fruit();
            Fruit f2 = new Fruit();
            Fruit f3 = new Fruit();
            Fruit f4 = new Fruit();
            Fruit f5 = new Fruit();

            f1.setName("Orange");
            f1.setPrice(2.00f);
            f1.setQuantity(10);
            f1.addCategory(categoryRepository.findById("Citrus").orElse(null));
            f1.setImage("imageURL");
            f2.setName("Banana");
            f2.setPrice(0.90f);
            f2.setQuantity(40);
            f2.addCategory(categoryRepository.findById("Exotic").orElse(null));
            f2.setImage("imageURL");

            f3.setName("Pineapple");
            f3.setPrice(4.50f);
            f3.setQuantity(40);
            f3.addCategory(categoryRepository.findById("Exotic").orElse(null));
            f3.setImage("imageURL");

            f4.setName("Apple");
            f4.setPrice(1.00f);
            f4.setQuantity(20);
            f4.setImage("imageURL");

            f5.setName("Yuzu");
            f5.setPrice(4.00f);
            f5.setQuantity(15);
            f5.addCategory(categoryRepository.findById("Citrus").orElse(null));
            f5.addCategory(categoryRepository.findById("Exotic").orElse(null));
            f5.setImage("imageURL");

            fruitRepository.save(f1);
            fruitRepository.save(f2);
            fruitRepository.save(f3);
            fruitRepository.save(f4);
            fruitRepository.save(f5);
        };
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyGardenAppApplication.class);
    }


    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
