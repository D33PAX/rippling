package com.rippling.demo.controller;

import com.rippling.demo.dto.Product;
import com.rippling.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Validated
@RestController
public class AppController {

    Logger logger = LoggerFactory.getLogger(AppController.class);


    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductByID(@PathVariable long id){
        return service.getProductByID(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product p){
        logger.info("request: "+p.getId());


        service.addProduct(p);
        return p;
    }
}
