package com.hexaware.springdatajpaexample.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springdatajpaexample.dto.ProductDTO;
import com.hexaware.springdatajpaexample.entities.Product;
import com.hexaware.springdatajpaexample.repository.ProductIRepository;

@Service
public class ProductServiceImpl implements IProductService{
	private ProductIRepository repo;
	private ModelMapper modelMapper;
	
	
	@Autowired
	public ProductServiceImpl(ProductIRepository repo , ModelMapper modelMapper) {
		this.repo = repo;
		this.modelMapper = modelMapper;
	}
	
	public ProductDTO saveProduct(ProductDTO productdto) {
		//convert productdto to product in order to use the save() of jpa
		//Product productToSave = new Product(product.getName() , product.getDescription(), product.isActive());
		//Product productToSave = ProductMapper.mapToProduct(product);
		Product productToSave = this.modelMapper.map(productdto, Product.class);
		Product savedProduct = this.repo.save(productToSave);
		//convert from product to dto
		//ProductDTO returnProduct = new ProductDTO(savedProduct.getName() , savedProduct.getDescription() , savedProduct.isActive());
		//ProductDTO returnProduct = ProductMapper.mapToProductDTO(savedProduct);
		ProductDTO returnProduct = this.modelMapper.map(savedProduct, ProductDTO.class);
		return returnProduct;
	}
	
	public List<Product> saveProducts(List<Product> products){
		return this.repo.saveAll(products);
	}
	
	public List<Product> getAllProducts(){
		return this.repo.findAll();
	}
	
	public Optional<Product> getProductById(Long id) {
		return this.repo.findById(id);
	}

	
	@Override
	public List<Product> searchProducts(String productName) {
		return this.repo.searchProductsHQL(productName);
	}

	@Override
	public boolean deleteProductById(Long id) {
		 this.repo.deleteById(id);
		 return true;
	}

	@Override
	public List<Product> findByNameOrDescription(String keyword) {
		return this.repo.findByNameOrDescription(keyword);
	}

	
	@Override
	public List<Product> readFirst2ByName(String name) {
		return this.repo.findTop2ByNameContaining(name);
	}

	@Override
	public List<Product> findByNameContainingIgnoreCase(String name) {
		return this.repo.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Product> searchByKeyword(String keyword) {
		return this.repo.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);	
	}

	
	
	
	
	
	
	
	
	
	
}
