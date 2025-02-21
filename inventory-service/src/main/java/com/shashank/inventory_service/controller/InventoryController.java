package com.shashank.inventory_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shashank.inventory_service.dto.InventoryResponse;
import com.shashank.inventory_service.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired 
	InventoryService inventoryservice;
	
//	http:localhost:8088/api/inventory/get?skucode=iphone_13&skucode=iphone_13_red
	@GetMapping("get")
	public List<InventoryResponse> isInStock(@RequestParam List<String> skucode) {
		System.out.print("hello1");
		return inventoryservice.isInStock(skucode);
	}
}
