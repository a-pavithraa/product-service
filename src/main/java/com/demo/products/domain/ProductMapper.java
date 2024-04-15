package com.demo.products.domain;

class ProductMapper {

    static Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice());
    }
    static ProductEntity toProductEntity(Product product) {
        return new ProductEntity(
                product.name(),
                product.description(),
                product.price());
    }
}
