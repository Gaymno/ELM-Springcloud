package org.example.service.impl;


import jakarta.annotation.Resource;
import org.example.feign.CartService;
import org.example.feign.OrderDetailService;
import org.example.mapper.OrdersMapper;
import org.example.po.Cart;
import org.example.po.OrderDetailet;
import org.example.po.Orders;
import org.example.service.OrdersService;
import org.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
	

	@Autowired
	private OrdersMapper ordersMapper;

	@Resource
	private OrderDetailService orderDetailService;

	@Resource
	private CartService cartService;

	@Override
	@Transactional
	public int createOrders(Orders orders) {
		//1、查询当前用户购物车中当前商家的所有食品
		Cart cart = new Cart();
		cart.setUserId(orders.getUserId());
		cart.setBusinessId(orders.getBusinessId());
		List<Cart> cartList = cartService.listCart(cart);
		
		//2、创建订单（返回生成的订单编号）
		orders.setOrderDate(CommonUtil.getCurrentDate());
		ordersMapper.saveOrders(orders);
		int orderId = orders.getOrderId();
		
		//3、批量添加订单明细
		List<OrderDetailet> list = new ArrayList<>();
		for(Cart c : cartList) {
			OrderDetailet od = new OrderDetailet();
			od.setOrderId(orderId);
			od.setFoodId(c.getFoodId());
			od.setQuantity(c.getQuantity());
			list.add(od);
		}
		orderDetailService.saveOrderDetailetBatch(list);
		
		//4、从购物车表中删除相关食品信息
		cartService.removeCart(cart);
		
		return orderId;
	}
	
	@Override
	public Orders getOrdersById(Integer orderId) {
		return ordersMapper.getOrdersById(orderId);
	}
	
	@Override
	public List<Orders> listOrdersByUserId(String userId){
		return ordersMapper.listOrdersByUserId(userId);
	}

	@Override
	public int confirmOrder(Integer orderId) {
		return ordersMapper.confirmOrder(orderId);
	}
}
