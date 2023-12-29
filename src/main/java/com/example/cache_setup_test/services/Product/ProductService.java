package com.example.cache_setup_test.services.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cache_setup_test.repository.ProductReadOnlyDao;
import com.example.cache_setup_test.utils.JsonUtils;

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

    @Override
    public List<ProductResponse> fetchAllProduct()
    {
        List<Product> productListFromDB = productReadOnlyDao.findAll();
        List<ProductResponse> productReponseList = new ArrayList<>();

        for(Product product : productListFromDB) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
            productReponseList.add(productResponse);
        
        }
        log.info("Product Response : {}",productReponseList);
        return productReponseList;
    }

    public void buildProductCache() throws IOException
    {
        List<ProductResponse> productResponseFromDB = fetchAllProduct();
        Map<String,String> productDetailsMap = new HashMap<>();
        for(ProductResponse productResponse : productResponseFromDB) {
            productDetailsMap.put(String.valueOf(productResponse.getId()),JsonUtils.serialize(productResponse));
        }
        if(!productDetailsMap.isEmpty())
        {
            // put into cache
            //externalService
        }
    }

    @Override
    public void init() throws IOException
    {
        buildProductCache();
    }
    
}
