package com.shashank.inventory_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shashank.inventory_service.dto.InventoryResponse;
import com.shashank.inventory_service.model.Inventory;
import com.shashank.inventory_service.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository repo;

	@Transactional(readOnly=true)
	public List<InventoryResponse> isInStock(List<String> skucode) {
		List<Inventory> inventory = repo.getBySkuCodeIn(skucode);
		List<InventoryResponse> response = new ArrayList<>();
		for(Inventory i:inventory) {
			InventoryResponse r = InventoryResponse.builder()
					.skuCode(i.getSkuCode())
					.isInStock(i.getQuantity()>0?true:false).build();
			response.add(r);
		}
		return response;
	}
}
