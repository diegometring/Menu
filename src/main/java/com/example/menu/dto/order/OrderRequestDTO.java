package com.example.menu.dto.order;

import com.example.menu.enums.StatusOrder;

import java.time.LocalDateTime;

public record OrderRequestDTO(LocalDateTime dateOrders, StatusOrder statusOrder) {
}
