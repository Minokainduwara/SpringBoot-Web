package com.example.webdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Product {

    private int proId;
    private String proName;
    private int price;
}
