package com.hexaware.springdatajpaexample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springdatajpaexample.dto.ProductDTO;
import com.hexaware.springdatajpaexample.entities.Product;
import com.hexaware.springdatajpaexample.service.IProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	private IProductService productService;
	
	@Autowired
	public ProductController(IProductService productService) {
		this.productService = productService;
	}
	
	//-----------GET------------
	@GetMapping("/getproductbyname")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam("name") String productName){
		return ResponseEntity.ok(this.productService.searchProducts(productName));
	}
	
	@GetMapping("/getproductbynameordescription")
	public ResponseEntity<List<Product>> findByNameOrDescription(@RequestParam("keyword") String keyword){
		return ResponseEntity.ok(this.productService.findByNameOrDescription(keyword));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProductsByKeyword(@RequestParam("keyword") String keyword){
		return ResponseEntity.ok(this.productService.searchByKeyword(keyword));
	}
	
	@GetMapping("/getproductsbyname")
	public ResponseEntity<List<Product>> findByName(@RequestParam("name") String name){
	    return ResponseEntity.ok(this.productService.findByNameContainingIgnoreCase(name));
	}

	@GetMapping("/getfirst2productbyname")
	public ResponseEntity<List<Product>> findFirst2ByName(@RequestParam("name") String name){
		return ResponseEntity.ok(this.productService.readFirst2ByName(name));
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Optional<Product>> getByid(@PathVariable Long id){
		return ResponseEntity.ok(this.productService.getProductById(id));
	}
	
	
	@PostMapping("/addproduct")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO p) {
		ProductDTO savedProduct = this.productService.saveProduct(p);
		return ResponseEntity.ok(savedProduct);	}
	
	@DeleteMapping("/deleteproductbyid")
	public boolean deleteProductById(@RequestParam("id") Long id) {
		return this.productService.deleteProductById(id);
	}
	
	
	
}
