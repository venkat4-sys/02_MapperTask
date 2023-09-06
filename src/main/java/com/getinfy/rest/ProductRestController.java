package com.getinfy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.getinfy.binding.ProductBinding;
import com.getinfy.entity.ProductEntity;
import com.getinfy.service.ProductService;

@RestController
public class ProductRestController {
	
	
	@Autowired
	private ProductService service;

	@PostMapping("/saveProduct")
	private ResponseEntity<String> saveProduct(@RequestBody ProductBinding binding) {

		boolean saveUser = service.saveProduct(binding);

		if (saveUser) {

			return new ResponseEntity<String>("Data saved successfully", HttpStatus.CREATED);

		}
		return new ResponseEntity<String>("Data not saved", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getProduct")
	private ResponseEntity<ProductEntity> getentity(@RequestBody ProductBinding binding) {

		 ProductEntity entity = service.toEntity(binding);

		return new ResponseEntity<ProductEntity>(entity, HttpStatus.OK);
	}

	@GetMapping("/getProductBinding")
	private ResponseEntity<ProductBinding> getBinding(@RequestBody ProductEntity entity) {

		ProductBinding binding = service.toBinding(entity);

		return new ResponseEntity<ProductBinding>(binding, HttpStatus.OK);

	}
	
	
	@GetMapping("/getProducts")
	private ResponseEntity<List<ProductBinding>> getProducts() {

		List<ProductBinding> all = service.getAll();

		return new ResponseEntity<List<ProductBinding>>(all, HttpStatus.OK);

	}
	
	@GetMapping("/get/{id}")
	private ResponseEntity<ProductBinding> getProduct(@PathVariable Integer id) {

		 ProductBinding product = service.getProduct(id);

		return new ResponseEntity<ProductBinding>(product, HttpStatus.OK);

	}

	
	

}
