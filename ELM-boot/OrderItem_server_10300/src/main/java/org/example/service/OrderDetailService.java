package org.example.service;

import org.example.po.OrderDetailet;

import java.util.List;

public interface OrderDetailService {
    int saveOrderDetailetBatch(List<OrderDetailet> list);
}
