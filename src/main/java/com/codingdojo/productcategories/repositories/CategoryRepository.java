package com.codingdojo.productcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productcategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{	
	
	List<Category> findAll();
	
	Optional<Category> findById(Long id);
	
	Long deleteByIdStartingWith(String search);
	
	Category save(Category dojo);
}
