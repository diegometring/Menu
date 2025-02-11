package com.example.menu.services.stock;

import com.example.menu.dto.stock.StockRequestDTO;
import com.example.menu.entity.Stock;

public interface IStockService {
    Stock addProduct(StockRequestDTO data);
    Stock updateProduct(StockRequestDTO data);
}
