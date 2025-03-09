package com.example.menu.entity;

import com.example.menu.enums.StatusReservation;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Reservation {
    private LocalDateTime reservationDate;

    @Enumerated(EnumType.STRING)
    private StatusReservation statusReservation;
}
