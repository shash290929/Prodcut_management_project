package com.shashank.inventory_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shashank.inventory_service.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long>{
	List<Inventory> getBySkuCodeIn(List<String> skucode);
}
