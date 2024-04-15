package com.demo.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestProductsApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductsApplication::main).with(TestProductsApplication.class).run(args);
	}

}
