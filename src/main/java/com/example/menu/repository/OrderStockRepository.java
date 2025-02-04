package com.example.menu.repository;

import com.example.menu.entity.OrderStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStockRepository extends JpaRepository <OrderStock, Long> {
}
