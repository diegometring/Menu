package com.example.menu.entity;

import com.example.menu.enums.StatusOrder;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateOrders;

    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "ordered")
    private List<OrderedStock> orderedStocks;

    public Ordered(Long id, LocalDateTime dateOrders, StatusOrder statusOrder, Client client, Menu menu, List<OrderedStock> orderedStocks) {
        this.id = id;
        this.dateOrders = dateOrders;
        this.statusOrder = statusOrder;
        this.client = client;
        this.menu = menu;
        this.orderedStocks = orderedStocks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOrders() {
        return dateOrders;
    }

    public void setDateOrders(LocalDateTime dateOrders) {
        this.dateOrders = dateOrders;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<OrderedStock> getOrderStocks() {
        return orderedStocks;
    }

    public void setOrderStocks(List<OrderedStock> orderedStocks) {
        this.orderedStocks = orderedStocks;
    }
}