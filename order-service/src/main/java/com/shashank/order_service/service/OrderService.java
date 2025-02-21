package com.shashank.order_service.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.shashank.order_service.dto.InventoryResponse;
import com.shashank.order_service.dto.OrderLineItemsDto;
import com.shashank.order_service.dto.OrderRequest;
import com.shashank.order_service.model.Order;
import com.shashank.order_service.model.OrderLineItems;
import com.shashank.order_service.repository.OrderRepository;
import java.util.*;

@Service
@Transactional
public class OrderService {
	@Autowired
	OrderRepository repo;
	
	@Autowired
	WebClient webClient;
	
	public void placeOrder(OrderRequest orderRequest) {
		List<OrderLineItemsDto> orderlineitemsdto = orderRequest.getOrderLineItemsListdto();
		List<OrderLineItems> orderlineitems = new ArrayList<>();
		for(OrderLineItemsDto d:orderlineitemsdto) {
			OrderLineItems items = OrderLineItems.builder().id(d.getId()).skucode(d.getSkucode()).price(d.getPrice()).quantity(d.getQuantity()).build();
			orderlineitems.add(items);
		}
		Order order = Order.builder().orderNumber(UUID.randomUUID().toString())
				.orderLineItemsList(orderlineitems).build();
		
		//Call Inventory Service, and place order if product is in Stock
		
		List<OrderLineItemsDto> request = orderRequest.getOrderLineItemsListdto();
		List<String> skuCodes = new ArrayList<>();
		
		for(OrderLineItemsDto o: request) {
			skuCodes.add(o.getSkucode());
		}
		
		InventoryResponse[] inventoryresponsesArray = webClient.get().uri("http://localhost:8088/api/inventory/get", 
				uriBuilder -> uriBuilder.queryParam("skucode", skuCodes).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();
		
		boolean result=true;
		for(InventoryResponse i:inventoryresponsesArray) {
			if(!i.isInStock()) {
				result=false;
				break;
			}
		}
		
		if(result)
			repo.save(order);
		else
			throw new IllegalArgumentException("Product Not is Stock please try again");
	}
}
