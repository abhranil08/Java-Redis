package com.example.cache_setup_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product {
    @Id
    private Long id;

    private String name;
    private String price;
    
}
