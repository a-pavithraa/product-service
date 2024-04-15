package com.demo.products.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@RequiredArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_seq")
    private Long id;


    @NotEmpty(message = "Product name is required")
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private String description;


    @NotNull(message = "Product price is required") @DecimalMin("0.1")
    @Column(nullable = false)
    private BigDecimal price;


    public ProductEntity(String name, String description, BigDecimal price) {

        this.name=name;
        this.description=description;
        this.price=price;
    }
}
