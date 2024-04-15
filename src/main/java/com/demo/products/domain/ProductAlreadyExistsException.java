package com.demo.products.domain;

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
    public static ProductAlreadyExistsException forName(String name) {
        return new ProductAlreadyExistsException("Product with Name " + name + " already exists");
    }
}

