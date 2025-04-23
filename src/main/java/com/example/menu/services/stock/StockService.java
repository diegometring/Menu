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
        Stock stock = new Stock(); //cria uma nova entidade e define os atributos com os dados recebidos do dto
        stock.setNameProduct(data.nameProduct());
        stock.setQuantity(data.quantity());
        stock.setUnitPrice(data.unitPrice());
        return stockRepository.save(stock); //retorna a entidade salva no banco
    }

    @Override
    public Stock updateStock(Long id, StockRequestDTO data) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found")); //busca a entidade menu pelo id e se não for encontrada da um erro
        stock.setNameProduct(data.nameProduct());
        stock.setQuantity(data.quantity());
        stock.setUnitPrice(data.unitPrice());
        return stockRepository.save(stock); //retorna a entidade salva no banco
    }

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll(); //retorna todas as receitas em uma lista
    }

    @Override
    public Stock getById(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found")); //retorna a entidade salva no banco, se não for encontrado recebe uma mensagem de erro
    }

    @Override
    public void deleteStock(Long id) {
        if (!stockRepository.existsById(id)) { // verifica se o id que está sendo solicitado pra deletar existe no banco
            throw new RuntimeException("Stock not found");
        }
        stockRepository.deleteById(id); //deleta pelo id
    }
}