package com.hexaware.springdatajpaexample.mapper;

import com.hexaware.springdatajpaexample.dto.ProductDTO;
import com.hexaware.springdatajpaexample.entities.Product;

public class ProductMapper {
	public static ProductDTO mapToProductDTO(Product p) {
		return new ProductDTO(p.getName() , p.getDescription() , p.isActive());
	}
	public static Product mapToProduct(ProductDTO p) {
		return new Product(p.getName() , p.getDescription() , p.isActive());
	}

}
