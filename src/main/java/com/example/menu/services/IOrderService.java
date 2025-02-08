package com.example.menu.services;

import com.example.menu.entity.Order;

public interface IOrderService {
    Order createOrder(OrderRequestDTO data);
}
