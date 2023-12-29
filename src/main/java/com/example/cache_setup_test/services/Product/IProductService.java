package com.example.cache_setup_test.services.Product;

import java.util.List;

import com.example.cache_setup_test.objects.ProductResponse;

public interface IProductService {

    public ProductResponse fetchProductById(Long id);
    public List<ProductResponse> fetchAllProduct();
}
