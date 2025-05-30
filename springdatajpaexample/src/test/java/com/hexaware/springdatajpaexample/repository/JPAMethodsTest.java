package com.hexaware.springdatajpaexample.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.springdatajpaexample.entities.Product;

@SpringBootTest
public class JPAMethodsTest {
	
	private ProductIRepository productRepo;

	@Autowired
	public JPAMethodsTest(ProductIRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	@Disabled
	@Test
	void saveMethod() {
		 Product existing = productRepo.findByName("Scanner HP");
		    if (existing == null) {
		        Product p = new Product();
		        p.setName("Scanner HP");
		        p.setDescription("High resolution Scanner from HP");
		        p.setActive(true);
		        productRepo.save(p);
		    }
	}
	

	@Disabled
	@Test
	void updateUsingSaveMethod() {
		Long id = 8L;
		Optional<Product> existingProduct = this.productRepo.findById(id);
		Product existing = existingProduct.get();
		existing.setName("Scanner DELL");
		existing.setDescription("High resolution Scanner from DELL");
		this.productRepo.save(existing);
		
	}

	@Disabled
	@Test
	void saveAllMethod() {
		Product p = new Product();
		p.setName("Monitor LG");
		p.setDescription("32 Inch curved AMOLED Display");
		p.setActive(true);
		Product p1 = new Product();
		p1.setName("Zebronics wireless keyboard");
		p1.setDescription("Wireless keyboard , handy and perfect");
		p1.setActive(true);
		Product p2 = new Product();
		p2.setName("Samsung Monitor");
		p2.setDescription("32 Inch Monitor with Amoled Display");
		p2.setActive(true);
		this.productRepo.saveAll(List.of(p , p1 , p2));
	}

	@Disabled
	@Test
	void findAllTest() {
		List<Product> prodList = this.productRepo.findAll();
		prodList.forEach(p -> System.out.println(p.getName() + " " + p.getDescription() + " " + p.getDateCreated() + "\n"));
	}

	@Disabled
	@Test
	void deleteByIdMethod() {
		Long id = 9L;
		this.productRepo.deleteById(id);
	}

	@Disabled
	@Test
	void delete() {
		Long id = 13L;
		Optional<Product> savedProduct = this.productRepo.findById(id);
		Product saved = savedProduct.get();
		this.productRepo.delete(saved);
	}
	
}
