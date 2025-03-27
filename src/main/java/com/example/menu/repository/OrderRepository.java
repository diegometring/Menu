package com.example.menu.repository;

import com.example.menu.entity.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Ordered, Long> {
}
