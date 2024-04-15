package com.demo.products.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {

        List<Product> products = productRepository.findAll().stream().map(ProductMapper::toProduct).collect(Collectors.toList());

        return products;
    }

    public Optional<Product> getProductByCode(Long id) {
        return productRepository.findById(id).map(ProductMapper::toProduct);
    }
    public ProductEntity addProduct(Product product) {
        if (productRepository.findByName(product.name()).isPresent())
                throw  ProductAlreadyExistsException.forName(product.name());
        ProductEntity productEntity=ProductMapper.toProductEntity(product);

        return productRepository.save(productEntity);

    }
}
