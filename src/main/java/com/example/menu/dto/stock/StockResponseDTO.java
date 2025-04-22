package com.example.menu.dto.stock;

import com.example.menu.entity.Stock;

public record StockResponseDTO(
        Long id,
        String nameProduct,
        int quantity,
        double unitPrice
) {
    public StockResponseDTO(Stock stock) {
        this(stock.getId(), stock.getNameProduct(), stock.getQuantity(), stock.getUnitPrice());
    }
}