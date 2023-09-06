package com.getinfy.service;

import java.util.List;

import org.mapstruct.Mapper;

import com.getinfy.binding.ProductBinding;
import com.getinfy.entity.ProductEntity;

@Mapper
public interface ProductService {
	
	public ProductBinding toBinding(ProductEntity entity);
	
	public ProductEntity toEntity(ProductBinding binding);
	
	public boolean saveProduct(ProductBinding binding);
	
    public List<ProductBinding> getAll();
    
    public ProductBinding getProduct(Integer id);
}
