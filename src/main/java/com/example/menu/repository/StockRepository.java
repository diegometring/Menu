package com.example.menu.repository;

import com.example.menu.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository <Stock, Long> {
}
