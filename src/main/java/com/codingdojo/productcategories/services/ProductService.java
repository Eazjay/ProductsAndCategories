package com.codingdojo.productcategories.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productcategories.models.Category;
import com.codingdojo.productcategories.models.CategoryProduct;
import com.codingdojo.productcategories.models.Product;
import com.codingdojo.productcategories.repositories.CategoryProductRepository;
import com.codingdojo.productcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryProductRepository categoryProductRepository;
	
	public ProductService(ProductRepository productRepository, CategoryProductRepository categoryProductRepository) {
		this.productRepository = productRepository;
		this.categoryProductRepository = categoryProductRepository;
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalD = productRepository.findById(id);
		if(optionalD.isPresent()) {
			return optionalD.get();
		}
		else {
			return null;
		}
	}
	
	
	public Product createProduct(Product d) {
		return productRepository.save(d);
	}
	
	
	public void deleteProduct(Long id) {
		Product d = findProduct(id);
		productRepository.delete(d);
	}
	
	public Product updateProduct(Product d) {
		return productRepository.save(d);
	}
	
	public CategoryProduct saveRelationship(CategoryProduct cp) {
		return categoryProductRepository.save(cp);
	}

	public List<Category> allCategories() {
		return allCategories();
	}
}

