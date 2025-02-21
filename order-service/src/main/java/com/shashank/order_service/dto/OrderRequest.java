package com.shashank.order_service.dto;

import java.util.List;

import com.shashank.order_service.model.Order;
import com.shashank.order_service.model.OrderLineItems;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
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
public class OrderRequest {
	private List<OrderLineItemsDto> orderLineItemsListdto;
}
