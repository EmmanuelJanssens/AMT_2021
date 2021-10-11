package com.amt.mygarden;

import com.amt.mygarden.models.Fruit;
import com.amt.mygarden.repository.FruitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
@SpringBootApplication
@Component
public class MyGardenAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(MyGardenAppApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(FruitRepository repository) throws Exception {
        return (String[] args) -> {

       repository.save(new Fruit("Orange"));
       repository.save(new Fruit("Banana"));
       repository.save(new Fruit("Pineapple"));
       repository.save(new Fruit("Apple"));
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
