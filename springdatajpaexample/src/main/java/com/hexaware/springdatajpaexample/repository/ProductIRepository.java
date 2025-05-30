package com.hexaware.springdatajpaexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.springdatajpaexample.entities.Product;

@Repository
public interface ProductIRepository extends JpaRepository<Product, Long> {

	//HQL
	//LIKE "%MOUSE%"
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :productName, '%') "
    		+ "OR p.description  LIKE CONCAT('%', :productName, '%') ")
    List<Product> searchProductsHQL(String productName);
    
	 //JPQL
	 //LIKE "%MOUSE%"
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :productName, '%') "
    		+ "OR p.description  LIKE CONCAT('%', :productName, '%') ")    
    List<Product> searchProductsJPQL(String productName);
    
    //Native Query
    @Query(value = "SELECT * FROM products p WHERE p.name LIKE CONCAT('%', :productName, '%') "
    		+ "OR p.description LIKE CONCAT('%', :productName, '%') " , nativeQuery = true)    
    List<Product> searchProductsSQL(String productName);
    
    
    //HQL 
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :keyword, '%')"
    		+ " OR p.description LIKE CONCAT('%', :keyword, '%')")
    List<Product> findByNameOrDescription(String keyword);
    
    List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
    
    List<Product> findByNameContainingIgnoreCase(String name);
    
    List<Product> findTop2ByNameContaining(String name);

	Product findByName(String name);
    
    
}
