package com.shashank.product_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.shashank.product_service.repository.productRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import com.shashank.product_service.model.Product;
import com.shashank.product_service.dto.ProductRequest;
import com.shashank.product_service.dto.ProductResponse;

@Service
@Slf4j
public class productService {
	
	@Autowired
	productRepository repo;
	
	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();
		repo.save(product);
		log.info("product {} is saved",product.getId());
	}

	public List<ProductResponse> getAllProduct() {
		List<Product> product = repo.findAll();
		List<ProductResponse> productresponse = new ArrayList<>();
		for(Product p:product) {
			ProductResponse r = ProductResponse.builder().id(p.getId()).name(p.getName()).description(p.getDescription()).price(p.getPrice()).build();
			productresponse.add(r);
		}
		return productresponse;
	}
}
