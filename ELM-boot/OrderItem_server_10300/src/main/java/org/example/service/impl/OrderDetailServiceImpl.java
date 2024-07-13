package org.example.service.impl;

import org.example.mapper.OrderDetailetMapper;
import org.example.po.OrderDetailet;
import org.example.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailetMapper orderDetailetMapper;
    @Override
    public int saveOrderDetailetBatch(List<OrderDetailet> list) {
        return orderDetailetMapper.saveOrderDetailetBatch(list);
    }
}
