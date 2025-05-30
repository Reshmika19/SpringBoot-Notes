package com.hexaware.springdatajpasample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.springdatajpasample.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	//HQL
	//LIKE "%MOUSE%"
	@Query("SELECT p from Product p WHERE p.name LIKE CONCAT('%',:productName,'%')"
		+"OR " + "p.description LIKE CONCAT('%',:productName,'%')")
		List<Product> searchProducts(String productName);
	
	//JPQL
		//LIKE "%MOUSE%"
		@Query("SELECT p from Product p WHERE p.name LIKE CONCAT('%',:productName,'%')")
			List<Product> searchProductsJPQL(String productName);
		
		@Query(value="SELECT * FROM products p WHERE p.name LIKE CONCAT('%',:productName,'%') " +
	             "OR p.description LIKE CONCAT('%',:productName,'%')", nativeQuery=true)
	List<Product> searchProductsNative(@Param("productName") String productName);

		
	
	 @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :productName, '%')"
	    		+ " OR p.description LIKE CONCAT('%', :productName, '%')")
	    List<Product> findByNameOrDescription(String name);

	 @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	 List<Product> readFirst2ByName(@Param("name") String name);

	
}
