package org.example.service;



import org.example.po.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrdersService {

	public int createOrders(Orders orders);
	public Orders getOrdersById(Integer orderId);
	public List<Orders> listOrdersByUserId(String userId);

	public  int confirmOrder(Integer orderId);
}
