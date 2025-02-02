package com.example.menu.entity;

import com.example.menu.enums.StatusOrder;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;
}
