package org.example.mapper;


import org.apache.ibatis.annotations.*;
import org.example.po.Cart;

import java.util.List;

@Mapper
public interface CartMapper {

	public List<Cart> listCart(Cart cart);
	
	@Insert("insert into cart values(null,#{foodId},#{businessId},#{userId},1)")
	public int saveCart(Cart cart);
	
	@Update("update cart set quantity=#{quantity} where foodId=#{foodId} and businessId=#{businessId} and userId=#{userId}")
	public int updateCart(Cart cart);

	@Delete("delete from cart where userId=#{userId} and foodId = #{foodId} and businessId=#{businessId}")
	public int removeCart(Cart cart);
}
