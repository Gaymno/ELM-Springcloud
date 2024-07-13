package org.example.feign;

import org.example.po.OrderDetailet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("orderdetail-server")
public interface OrderDetailService {
    @PostMapping("/OrderDetailController/saveOrderDetailetBatch")
    public int saveOrderDetailetBatch(List<OrderDetailet> list);
}
