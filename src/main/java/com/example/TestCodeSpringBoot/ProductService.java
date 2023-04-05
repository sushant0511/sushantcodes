package com.example.TestCodeSpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	MyRepo repo;
	
	
	public List<Product> showProduct()
	{
		return repo.findAll();
	}


	public void myMethod(Product product) {
		repo.save(product);
		
	}
	
	
	
	
	
}
