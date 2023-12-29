package com.example.cache_setup_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cache_setup_test.entity.Product;
import com.example.cache_setup_test.common.annotations.*;

@ReadOnlyRepository
public interface ProductReadOnlyDao extends JpaRepository<Product,Long>{
    
}
