package org.example.mapper;


import org.apache.ibatis.annotations.*;
import org.example.po.Orders;

import java.util.List;

@Mapper
public interface OrdersMapper {

	@Insert("insert into orders(userId,businessId,orderDate,orderTotal,daId,orderState) values(#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},0)")
	@Options(useGeneratedKeys=true,keyProperty="orderId",keyColumn="orderId")
	public int saveOrders(Orders orders);


	public Orders getOrdersById(Integer orderId);
	public List<Orders> listOrdersByUserId(String userId);

	@Update("UPDATE orders SET orderState = 1 WHERE orderId = #{orderId}")
	public int confirmOrder(Integer orderId);
}
