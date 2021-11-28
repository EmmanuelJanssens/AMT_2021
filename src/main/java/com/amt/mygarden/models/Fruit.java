package com.amt.mygarden.models;

import com.amt.mygarden.repository.ItemRepository;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Fruit {

    @Id
    @NotNull
    private String name;
    private float price;
    private int quantity;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "fruit_categories",
            joinColumns = {@JoinColumn(name = "fruit_name")},
            inverseJoinColumns = {@JoinColumn(name = "category_name")}
    )

    private Set<Category> categories = new HashSet<>();
    private String image = "";
    private String description = "";
    @Transient
    MultipartFile imageFile;

    public Fruit(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException();

        setName(name);
    }

    public Fruit() {
    }

    public void addCategory(Category c) {
        this.categories.add(c);
        c.getFruits().add(this);
    }

    public void deleteCategory(Category c) {
        c.getFruits().remove(this);
        this.categories.remove(c);
    }
    public void removeQuantity(){
        if(this.quantity!=0){
            this.quantity-=1;
        }
    }
    public void deleteCategories(){
        for (Category category : getCategories()){
            category.getFruits().remove(this);
        }
        categories.clear();
    }

    public void setCategories(Set<Category> categories){
        deleteCategories();
        for (Category category : categories){
            addCategory(category);
        }
    }

}
