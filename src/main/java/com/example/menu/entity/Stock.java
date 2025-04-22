package com.example.menu.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProduct;
    private int quantity;
    private double unitPrice;

    @OneToMany(mappedBy = "stock")
    private List<OrderedStock> orderedStocks;

    public Stock(Long id, String nameProduct, int quantity, double unitPrice, List<OrderedStock> orderedStocks) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.orderedStocks = orderedStocks;
    }

    public Stock() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
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

    public List<OrderedStock> getOrderStocks() {
        return orderedStocks;
    }

    public void setOrderStocks(List<OrderedStock> orderedStocks) {
        this.orderedStocks = orderedStocks;
    }
}