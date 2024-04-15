package com.demo.products.web.controller;

import com.demo.products.domain.Product;
import com.demo.products.domain.ProductEntity;
import com.demo.products.domain.ProductNotFoundException;
import com.demo.products.domain.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class ProductsController {
    private final ProductService productService;
    @GetMapping("/products")
    ResponseEntity<List<Product>> getProducts(){
        var products=productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);

    }
    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProductByCode(@PathVariable Long id) {
        return productService
                .getProductByCode(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forId(id));
    }
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    ProductEntity createProduct(@RequestBody @Valid Product product){
        return productService.addProduct(product);

    }


}
