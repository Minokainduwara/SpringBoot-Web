package com.example.webdemo.service;

import com.example.webdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(101,"Iphone",30000),
            new Product(102,"Camera", 34400)
    );
    public List<Product> getProducts() {
        return products;
    }
}
