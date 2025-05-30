package com.hexaware.springdatajpasample.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.hexaware.springdatajpasample.customexception.ResourceNotFoundException;
import com.hexaware.springdatajpasample.dto.ErrorDetails;
import com.hexaware.springdatajpasample.dto.ProductDTO;
import com.hexaware.springdatajpasample.entities.Product;
import com.hexaware.springdatajpasample.service.IProductService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // Exception handler for ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                "PRODUCT_NOT_FOUND"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Search products by name (accessible by USER or ADMIN)
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/getproductbyname")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("name") String productName) {
        List<Product> products = productService.searchProductsNative(productName);
        return ResponseEntity.ok(products);
    }

    // Create a product (ADMIN only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveproduct")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO savedProduct = productService.saveProduct(productDTO);
        return ResponseEntity.ok(savedProduct);
    }

    // Delete product by ID (ADMIN only)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deletebyid")
    public ResponseEntity<Boolean> deleteById(@RequestParam("id") Long id) {
        boolean deleted = productService.deleteByid(id);
        return ResponseEntity.ok(deleted);
    }

    // Get first 2 products by name (USER or ADMIN)
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/getproductfirst2byname")
    public ResponseEntity<List<Product>> findFirst2ByName(@RequestParam("name") String name) {
        List<Product> products = productService.readFirst2ByName(name);
        return ResponseEntity.ok(products);
    }

    // Get product by ID (USER or ADMIN)
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable("id") Long id) {
        Optional<Product> productOpt = productService.getProductById(id);
        return ResponseEntity.ok(productOpt);
    }
}
