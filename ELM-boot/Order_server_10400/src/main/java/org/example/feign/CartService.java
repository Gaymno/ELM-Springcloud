package org.example.feign;

import org.example.po.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("cart-server")
public interface CartService {
    @PostMapping("CartController/listCart")
    public List<Cart> listCart(@RequestBody Cart cart);
    @PostMapping("CartController/removeCart")
    public int removeCart(@RequestBody Cart cart);
}
