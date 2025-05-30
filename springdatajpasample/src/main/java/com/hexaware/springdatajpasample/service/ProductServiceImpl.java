package com.hexaware.springdatajpasample.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springdatajpasample.customexception.ResourceNotFoundException;
import com.hexaware.springdatajpasample.dto.ProductDTO;
import com.hexaware.springdatajpasample.entities.Product;
import com.hexaware.springdatajpasample.repository.ProductRepository;

@Service
public class ProductServiceImpl  implements IProductService{

    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public ProductDTO saveProduct(ProductDTO productDto) {
        // Convert DTO to entity
        Product productToSave = modelMapper.map(productDto, Product.class);

        // Save to DB
        Product savedProduct = repository.save(productToSave);

        // Convert saved entity back to DTO
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    public List<Product> saveProducts(List<Product> productList) {
        return repository.saveAll(productList);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
   	 Product foundProduct = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","id",id.toString()));
   	 return Optional.of(foundProduct);

    }

    public List<Product> searchProductsNative(String productName) {
        return repository.searchProductsNative(productName);
    }

    
    public boolean deleteByid(Long id) {
        repository.deleteById(id);
        return true;
    }

    public List<Product> findByNameOrDescription(String productName) {
        return repository.findByNameOrDescription(productName);
    }

    public List<Product> readFirst2ByName(String name) {
        return repository.readFirst2ByName(name);
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }
}
