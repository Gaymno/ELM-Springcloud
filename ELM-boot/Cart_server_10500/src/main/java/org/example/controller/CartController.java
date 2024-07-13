package org.example.controller;

import java.util.List;


import org.example.po.Cart;
import org.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/CartController")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping ("/listCart")
	public List<Cart> listCart(@RequestBody Cart cart) {
		return cartService.listCart(cart);
	}
	
	@PostMapping("/saveCart")
	public int saveCart(@RequestBody Cart cart) {
		return cartService.saveCart(cart);
	}
	
	@PostMapping("/updateCart")
	public int updateCart(@RequestBody Cart cart) {
		return cartService.updateCart(cart);
	}
	
	@PostMapping("/removeCart")
	public int removeCart(@RequestBody Cart cart) {
		return cartService.removeCart(cart);
	}
}
