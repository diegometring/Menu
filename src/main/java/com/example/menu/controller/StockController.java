package com.example.menu.controller;

import com.example.menu.dto.stock.StockRequestDTO;
import com.example.menu.dto.stock.StockResponseDTO;
import com.example.menu.entity.Stock;
import com.example.menu.services.stock.StockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/createStock")
    public ResponseEntity<StockResponseDTO> createStock(@RequestBody @Valid StockRequestDTO data) {
        Stock stock = stockService.createStock(data); //chama a service
        StockResponseDTO response = new StockResponseDTO(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StockResponseDTO> updateStock(@PathVariable Long id, @RequestBody @Valid StockRequestDTO data) {
        Stock stock = stockService.updateStock(id, data); //chama a service
        StockResponseDTO response = new StockResponseDTO(stock);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StockResponseDTO>> getAllStocks() {
        List<Stock> stocks = stockService.getAll(); //chamo a service para receber todos os itens do estoque em uma lista
        List<StockResponseDTO> resList = stocks.stream()//uso stream para transformar estoque em uma lista de dto
                .map(StockResponseDTO::new)// a cada entidade será criado um dto separado
                .collect(Collectors.toList()); //coleta os dto's para uma nova lista
        return ResponseEntity.ok(resList); //retorna status 200 e com o body do resList
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StockResponseDTO> getStockById(@PathVariable Long id) {
        Stock stock = stockService.getById(id); //chama a service
        StockResponseDTO response = new StockResponseDTO(stock);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id); //chama a service
        return ResponseEntity.noContent().build(); // retorna 204, indicando que a operação foi feita e que não nada para ser retornado
    }
}