package com.codingdojo.productcategories.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productcategories.models.Category;
import com.codingdojo.productcategories.models.CategoryProduct;
import com.codingdojo.productcategories.repositories.CategoryProductRepository;
import com.codingdojo.productcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final CategoryProductRepository categoryProductRepository;
	
	public CategoryService(CategoryRepository categoryRepository, CategoryProductRepository categoryProductRepository) {
		this.categoryRepository = categoryRepository;
		this.categoryProductRepository = categoryProductRepository;
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalD = categoryRepository.findById(id);
		if(optionalD.isPresent()) {
			return optionalD.get();
		}
		else {
			return null;
		}
	}
	
	
	public Category createCategory(Category d) {
		return categoryRepository.save(d);
	}
	
	
	public void deleteCategory(Long id) {
		Category d = findCategory(id);
		categoryRepository.delete(d);
	}
	
	public Category updateCategory(Category d) {
		return categoryRepository.save(d);
	}
	
	public CategoryProduct saveRelationship(CategoryProduct cp) {
		return categoryProductRepository.save(cp);
	}
}

