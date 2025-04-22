package com.example.menu.services.menu;

import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.entity.Menu;
import com.example.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Adicione a anotação @Service

import java.util.List;

@Service // indica que a classe é uma service
public class MenuService implements IMenuService {

    @Autowired //injeção de dependencia
    private MenuRepository menuRepository;

    @Override
    public Menu createMenu(MenuRequestDTO data) {
        Menu menu = new Menu(); //cria uma nova entidade e define os atributos com os dados recebidos do dto
        menu.setName(data.name());
        menu.setImage(data.image());
        menu.setDescription(data.description());
        menu.setPrice(data.price());
        menu.setCategory(data.category());
        menu.setAvailable(data.available());
        return menuRepository.save(menu); //retorna a entidade salva no banco
    }

    @Override
    public Menu updateMenu(Long id, MenuRequestDTO data) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found")); //busca a entidade menu pelo id e se não for encontrada da um erro
        menu.setName(data.name());
        menu.setImage(data.image());
        menu.setDescription(data.description());
        menu.setPrice(data.price());
        menu.setCategory(data.category());
        menu.setAvailable(data.available());
        return menuRepository.save(menu); //retorna a entidade salva no banco
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll(); //retorna todas as receitas em uma lista
    }

    @Override
    public Menu getById(Long id) {
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));//retorna a entidade salva no banco
    }

    @Override
    public void deleteMenu(Long id) {
        if (!menuRepository.existsById(id)) { // verifica se o id que está sendo solicitado pra deletar existe no banco
            throw new RuntimeException("Menu not found");
        }
        menuRepository.deleteById(id); //deleta pelo id
    }
}