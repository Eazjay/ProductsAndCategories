package com.codingdojo.productcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productcategories.models.Category;
import com.codingdojo.productcategories.models.CategoryProduct;
import com.codingdojo.productcategories.models.Product;
import com.codingdojo.productcategories.services.CategoryService;
import com.codingdojo.productcategories.services.ProductService;

@Controller
public class PCController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public PCController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "product.jsp";
	}
	
	@RequestMapping(value="/products/create", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "product.jsp";
		}
		else {
			Product p = productService.createProduct(product);
			return "redirect:/products/" + p.getId();
		}
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "category.jsp";
	}
	
	@RequestMapping(value="/categories/create", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "category.jsp";
		}
		else {
			Category c = categoryService.createCategory(category);
			return "redirect:/categories/" + c.getId();
		}
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
	public String displayProduct(Model model, @PathVariable("id") Long id) {
		Product p = productService.findProduct(id);
		model.addAttribute("product", p);
		List<Category> category = categoryService.allCategories();
		model.addAttribute("categories", category);
		return "displayProduct.jsp";
	}
	
	@RequestMapping(value="/categories/add", method=RequestMethod.POST)
	public String addCategory(@RequestParam(value="product") Long product,
							@RequestParam(value="category") Long category) {
		Product p = productService.findProduct(product);
		Category c = categoryService.findCategory(category);
		CategoryProduct cp = new CategoryProduct(p, c);
		productService.saveRelationship(cp);
		return "redirect:/products/" + p.getId();
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
	public String displayCategory(Model model, @PathVariable("id") Long id) {
		Category c = categoryService.findCategory(id);
		model.addAttribute("category", c);
		List<Product> product = productService.allProducts();
		model.addAttribute("products", product);
		return "displayCategory.jsp";
	}
	
	@RequestMapping(value="/products/add", method=RequestMethod.POST)
	public String addProduct(@RequestParam(value="category") Long category,
							@RequestParam(value="product") Long product) {
		
		Product p = productService.findProduct(product);
		Category c = categoryService.findCategory(category);
		CategoryProduct cp = new CategoryProduct(p, c);
		categoryService.saveRelationship(cp);
		return "redirect:/categories/" + c.getId();
	}
	
	@RequestMapping(value="/products/{id}/delete", method=RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/products/new";
	}
	
	@RequestMapping(value="/categories/{id}/delete", method=RequestMethod.DELETE)
	public String deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/categories/new";
	}
}

