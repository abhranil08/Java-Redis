package com.example.cache_setup_test.services.Product;

import com.example.cache_setup_test.objects.ProductResponse;

public interface IProductService {

    public ProductResponse fetchProductById(Long id);
    
}
