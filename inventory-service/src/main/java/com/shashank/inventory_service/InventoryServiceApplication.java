package com.shashank.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shashank.inventory_service.model.Inventory;
import com.shashank.inventory_service.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
		
	}
//	@Bean
//	public CommandLineRunner LoadData(InventoryRepository inventoryResponse) {
//		return args -> {
//			Inventory inventory1 = new Inventory();
//			inventory1.setSkuCode("iphone 13");
//			inventory1.setQuantity(10);
//			
//			Inventory inventory2 = new Inventory();
//			inventory2.setSkuCode("iphone 13 Red");
//			inventory2.setQuantity(0);
//			
//			inventoryResponse.save(inventory1);
//			inventoryResponse.save(inventory2);
//		};
//	}

}
