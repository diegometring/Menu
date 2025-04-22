package com.example.menu.services.stock;

import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.dto.stock.StockRequestDTO;
import com.example.menu.entity.Menu;
import com.example.menu.entity.Stock;

import java.util.List;

public interface IStockService {
    Stock createStock(StockRequestDTO data);
    Stock updateStock(Long id, StockRequestDTO data);
    List<Stock> getAll();
    Stock getById(Long id);
    void deleteStock(Long id);
}
