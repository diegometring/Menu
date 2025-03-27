package com.example.menu.entity;

import com.example.menu.enums.StatusTable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int tableNumber;
    private int capacity;

    @Enumerated(EnumType.STRING)
    private StatusTable statusTable;

    @OneToMany(mappedBy = "counter")
    private List<Reservation> reservations;

}