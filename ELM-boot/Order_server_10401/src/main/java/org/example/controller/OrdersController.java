package org.example.controller;

import java.util.List;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.po.Orders;
import org.example.po.Result;
import org.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/OrdersController")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@PostMapping("/createOrders")
	@CircuitBreaker(name = "backendA", fallbackMethod = "createOrdersDown")
	public Result createOrders(@RequestBody Orders orders) throws Exception {
		Integer code = ordersService.createOrders(orders);
		String message = "成功";
		Result result = new Result(code,message);
		return result;
	}

	@PostMapping("/getOrdersById")
	public Orders getOrdersById(@RequestBody Orders orders) throws Exception {
		return ordersService.getOrdersById(orders.getOrderId());
	}

	@PostMapping("/listOrdersByUserId")
	public List<Orders> listOrdersByUserId(@RequestBody Orders orders) throws Exception {
		return ordersService.listOrdersByUserId(orders.getUserId());
	}

	@PostMapping("/confirmOrder")
	public int confirmOrder(@RequestBody Orders orders) {
		return ordersService.confirmOrder(orders.getOrderId());
	}


	/*
	下面的方法是降级方法
	 */
	public Result createOrdersDown(Orders orders,Throwable e){
		e.printStackTrace();
		String message = "当前服务繁忙，请稍后再试";
		Result result = new Result(400,message);
		return result;
	}
}