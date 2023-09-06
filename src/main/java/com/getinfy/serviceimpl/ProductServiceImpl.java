package com.getinfy.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getinfy.binding.ProductBinding;
import com.getinfy.entity.ProductEntity;
import com.getinfy.repo.ProductRepo;
import com.getinfy.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public boolean saveProduct(ProductBinding binding) {
		
		ProductEntity entity=new ProductEntity();
		
		mapper.map(binding, entity);
		
		repo.save(entity);
		return true;
	}
	
	@Override
	public ProductBinding toBinding(ProductEntity entity) {
		
		ProductBinding bind=new ProductBinding();
		
		
		mapper.map(entity, bind);
		
		return bind;
	}
	
	@Override
	public ProductEntity toEntity(ProductBinding binding) {
		
		ProductEntity enity =new ProductEntity();
		mapper.map(binding, enity);
		return enity;
	}
	
	@Override
	public List<ProductBinding> getAll() {
		
		List<ProductEntity> listOfProducts = repo.findAll();
		
		List<ProductBinding> prodb=new ArrayList<>();
		
		for(ProductEntity prod:listOfProducts) {
			ProductBinding bind=new ProductBinding();
			
			mapper.map(prod, bind);
			prodb.add(bind);
		}
		return prodb;
		
	}
	
	@Override
	public ProductBinding getProduct(Integer id) {
		Optional<ProductEntity> findById = repo.findById(id);
		
		if(findById.isPresent()) {
			ProductEntity productEntity = findById.get();
			ProductBinding bind=new ProductBinding();
			mapper.map(productEntity, bind);
			return bind;
		}
		return null;
	}

}
