package com.example.cache_setup_test.services.Product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cache_setup_test.repository.ProductReadOnlyDao;

import lombok.extern.slf4j.Slf4j;

import com.example.cache_setup_test.objects.ProductResponse;
import com.example.cache_setup_test.entity.Product;

@Service
@Slf4j
public class ProductService implements IProductService{
    @Autowired
    ProductReadOnlyDao productReadOnlyDao;

    @Override
    public ProductResponse fetchProductById(Long id)
    {
        Optional<Product> productFromDB = productReadOnlyDao.findById(id);
        Product product = null;
        ProductResponse productResponse = new ProductResponse();
        if(productFromDB.isPresent())
            product = productFromDB.get();

        if(product!=null)
        {
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
        }
        log.info("Product Response : {}",productResponse);
        return productResponse;
    }
    
}
