package com.hexaware.springdatajpasample.mapper;

import com.hexaware.springdatajpasample.dto.ProductDTO;
import com.hexaware.springdatajpasample.entities.Product;

public class ProductMapper {

    public static ProductDTO mapToProductDTO(Product product) {
        return new ProductDTO(
            product.getName(),
            product.getDescription(),
            product.isActive()
        );
    }

    public static Product mapToProduct(ProductDTO productDTO) {
        return new Product(
            productDTO.getName(),
            productDTO.getDescription(),
            productDTO.isActive()
        );
    }
}
