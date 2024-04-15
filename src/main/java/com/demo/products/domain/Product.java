package com.demo.products.domain;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record Product(@NotBlank String name,  String description, @NotNull(message = "Product price is required") @DecimalMin("0.1") BigDecimal price) {}
