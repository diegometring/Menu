package com.example.menu.services.order;

import com.example.menu.dto.order.OrderRequestDTO;
import com.example.menu.entity.Ordered;

public interface IOrderService {
    Ordered createOrder(OrderRequestDTO data);
}
