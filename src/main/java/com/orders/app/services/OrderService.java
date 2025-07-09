package com.orders.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.app.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	
	public Double total(Order order) {
		return order.getBasic() + shippingService.shipment(order) - order.getBasic() * order.getDiscount() / 100.0;
	}
}
