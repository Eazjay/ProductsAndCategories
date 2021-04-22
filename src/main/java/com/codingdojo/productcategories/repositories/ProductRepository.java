package com.codingdojo.productcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{	
	
	List<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	Long deleteByIdStartingWith(String search);
	
	Product save(Product dojo);
}
