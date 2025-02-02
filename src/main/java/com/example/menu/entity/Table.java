package com.example.menu.entity;

import com.example.menu.enums.StatusTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private int tableNumber;

    @Enumerated(EnumType.STRING)
    private StatusTable statusTable;

}
