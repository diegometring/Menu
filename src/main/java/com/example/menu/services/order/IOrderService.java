package com.example.menu.services.order;

import com.example.menu.dto.order.OrderRequestDTO;
import com.example.menu.entity.Order;

public interface IOrderService {
    Order createOrder(OrderRequestDTO data);
}
