package com.codework.dream_shops.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category") //This attribute specifies the field in the Product entity that owns the relationship.
    //mappedBy indicates that the Product entity is the "owning side" of the relationship, meaning that the Product
    // entity has a reference (usually via a foreign key) to the Category.
    private List<Product> products;

    public Category(String name) {
    }
}
