package com.shashank.inventory_service.dto;

import com.shashank.inventory_service.model.Inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequest {
	private String id;
}
