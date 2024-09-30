package com.rippling.demo.service;

import com.rippling.demo.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    List<Product> products;

    public List<Product> getProducts(){

        return products;
    }

    public void addProduct(Product p) {

        if(this.products == null){
            products = new ArrayList<>();
        }
        products.add(p);
    }

    public Product getProductByID(long id) {
        return products.stream().filter(e -> e.getId() == id).findAny().orElse(null);
    }
}
