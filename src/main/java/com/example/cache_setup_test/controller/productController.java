package com.example.cache_setup_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache_setup_test.objects.ProductResponse;
import com.example.cache_setup_test.services.Product.IProductService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequestMapping("/v1/product")
public class productController {

    @Autowired
    IProductService productService;

    @GetMapping("/byId")
    public ResponseEntity<ProductResponse> getProductById(@RequestParam Long id){
        ProductResponse productResponse = productService.fetchProductById(id);
        log.info("Product fetched by id.");
        return ResponseEntity.ok(productResponse);
    }
    
}
