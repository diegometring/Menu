package com.example.menu.repository;

import com.example.menu.entity.OrderedStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStockRepository extends JpaRepository <OrderedStock, Long> {
}
