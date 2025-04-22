package com.example.menu.services.stock;

import com.example.menu.dto.stock.StockRequestDTO;
import com.example.menu.entity.Stock;
import com.example.menu.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockService implements IStockService {

    @Autowired
    private StockRepository stockRepository; //injeção de dependencia

    @Override
    public Stock createStock(StockRequestDTO data) {
        Stock stock = new Stock();
        stock.setNameProduct(data.nameProduct());
        stock.setQuantity(data.quantity());
        stock.setUnitPrice(data.unitPrice());
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, StockRequestDTO data) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
        stock.setNameProduct(data.nameProduct());
        stock.setQuantity(data.quantity());
        stock.setUnitPrice(data.unitPrice());
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getById(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    @Override
    public void deleteStock(Long id) {
        if (!stockRepository.existsById(id)) {
            throw new RuntimeException("Stock not found");
        }
        stockRepository.deleteById(id);
    }
}