package org.example.controller;

import org.example.po.OrderDetailet;
import org.example.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/OrderDetailController")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/saveOrderDetailetBatch")
    public int saveOrderDetailetBatch(@RequestBody List<OrderDetailet> list){
        return orderDetailService.saveOrderDetailetBatch(list);
    }
}
