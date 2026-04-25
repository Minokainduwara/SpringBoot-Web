package com.example.webdemo.service;

import com.example.webdemo.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Service
public class ProductService {

    List<Product> products = new ArrayList<>( Arrays.asList(
            new Product(101,"Iphone",30000),
            new Product(102,"Camera", 34400)
    ));

    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProId() == prodId)
                .findFirst().orElse(new Product(100,"No Item",0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
