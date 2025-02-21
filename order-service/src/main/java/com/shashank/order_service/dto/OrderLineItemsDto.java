package com.shashank.order_service.dto;

import java.math.BigDecimal;

import com.shashank.order_service.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
	private Long id;
	private String skucode;
	private BigDecimal price;
	private int quantity;
}
