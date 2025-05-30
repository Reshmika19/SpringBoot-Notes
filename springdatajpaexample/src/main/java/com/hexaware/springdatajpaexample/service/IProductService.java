package com.hexaware.springdatajpaexample.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.springdatajpaexample.dto.ProductDTO;
import com.hexaware.springdatajpaexample.entities.Product;

public interface IProductService {
	//JPA Methods
	ProductDTO saveProduct(ProductDTO p) ;
	List<Product> saveProducts(List<Product> products);
	List<Product> getAllProducts();
	Optional<Product> getProductById(Long id) ;
	
	//Custom Methods
	List<Product> searchProducts(String productName);
	boolean deleteProductById(Long id);
	List<Product> findByNameOrDescription(String keyword);
	List<Product> searchByKeyword(String keyword);
    List<Product> findByNameContainingIgnoreCase(String name);
	List<Product> readFirst2ByName(String name);
}
