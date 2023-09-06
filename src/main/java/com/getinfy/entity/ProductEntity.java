package com.getinfy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	
	@Id
	private Integer id;
	
	private String name;
	
	private Double price;

}
