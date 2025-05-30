package com.hexaware.springdatajpaexample.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.springdatajpaexample.entities.Product;

@SpringBootTest
public class QueryMethodsTest {
	
	private ProductIRepository productRepo;

	@Autowired
	public QueryMethodsTest(ProductIRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}
	
	@Test
	void SearchProductsSQLTest() {
		List<Product> prodList = this.productRepo.searchProductsSQL("mouse");
	}
	
}
