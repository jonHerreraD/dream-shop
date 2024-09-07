package com.codework.dream_shops.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;


    //The @JoinColumn annotation is typically used on the "many" side of a many-to-one or one-to-one relationship to
    // specify the column in the database table that should be used to join the two tables

    //The Product entity has a field category of type Category.
    //The @JoinColumn annotation is placed on this field to specify that the category_id column in the product table
    // should be used to join the product table with the category table.


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    //Cascade Type: This determines how operations performed on the parent entity (Product) will affect the child entities (Image).
    //CascadeType.ALL: This means that all types of operations (e.g., persist, merge, remove, refresh, detach) performed
    // on the Product entity will be cascaded to its associated Image entities.
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)//Orphan Removal: This specifies
    //that if an Image entity is removed from the images list of a Product, that Image entity should also be removed
    //from the database.
    //orphanRemoval = true: This ensures that if an Image is no longer associated with a Product (i.e., it is removed
    // from the list), it will be automatically deleted from the database. This is useful for preventing "orphan"
    // records that are no longer needed or connected to a parent entity.
    private List<Image> images;





    //Constructor needed for createProduct method in ProductService class
    //Now we can remove AllArgsConstructor annotation
    public Product(String name, String brand, BigDecimal price, int inventory, String description, Category category){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.category = category;
    }
}
