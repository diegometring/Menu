package com.example.menu.repository;

import com.example.menu.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Counter, Long> {
}
