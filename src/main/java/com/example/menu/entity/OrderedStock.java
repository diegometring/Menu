package com.example.menu.entity;

import jakarta.persistence.*;


@Entity
public class OrderedStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordered_id")
    private Ordered ordered;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private int quantity;
    private double unitPrice;

    public OrderedStock(Long id, Ordered ordered, Stock stock, int quantity, double unitPrice) {
        this.id = id;
        this.ordered = ordered;
        this.stock = stock;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ordered getOrder() {
        return ordered;
    }

    public void setOrder(Ordered ordered) {
        this.ordered = ordered;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}