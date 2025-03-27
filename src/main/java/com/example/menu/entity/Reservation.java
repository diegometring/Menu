package com.example.menu.entity;

import com.example.menu.enums.StatusReservation;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservationDate;


    @Enumerated(EnumType.STRING)
    private StatusReservation statusReservation;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "counter_id")
    private Counter counter;

    public Reservation(Long id, LocalDateTime reservationDate, StatusReservation statusReservation, Client client, Counter counter) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.statusReservation = statusReservation;
        this.client = client;
        this.counter = counter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public StatusReservation getStatusReservation() {
        return statusReservation;
    }

    public void setStatusReservation(StatusReservation statusReservation) {
        this.statusReservation = statusReservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Counter getTable() {
        return counter;
    }

    public void setTable(Counter counter) {
        this.counter = counter;
    }
}