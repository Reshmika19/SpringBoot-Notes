package com.hexaware.springdatajpasample.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.springdatajpasample.dto.ProductDTO;
import com.hexaware.springdatajpasample.entities.Product;

public interface IProductService {

    ProductDTO saveProduct(ProductDTO productDto);

    List<Product> saveProducts(List<Product> productList);

    List<Product> getProducts();

    Optional<Product> getProductById(Long id);

    List<Product> searchProductsNative(String productName);

    boolean deleteByid(Long id);

    List<Product> findByNameOrDescription(String productName);

    List<Product> readFirst2ByName(String name);

    Product saveProduct(Product product);
}
