package com.example.menu.services.menu;

import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.entity.Menu;
import com.example.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Adicione a anotação @Service

import java.util.List;

@Service // indica que a classe é uma service
public class MenuService implements IMenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu createMenu(MenuRequestDTO data) {
        Menu menu = new Menu();
        menu.setName(data.name());
        menu.setImage(data.image());
        menu.setDescription(data.description());
        menu.setPrice(data.price());
        menu.setCategory(data.category());
        menu.setAvailable(data.available());
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Long id, MenuRequestDTO data) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setName(data.name());
        menu.setImage(data.image());
        menu.setDescription(data.description());
        menu.setPrice(data.price());
        menu.setCategory(data.category());
        menu.setAvailable(data.available());
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu updateMenu(String name, MenuRequestDTO data) {
        Menu menu = menuRepository.findByName(name).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setName(data.name());
        menu.setImage(data.image());
        menu.setDescription(data.description());
        menu.setPrice(data.price());
        menu.setCategory(data.category());
        menu.setAvailable(data.available());
        return menuRepository.save(menu);
    }

    @Override
    public Menu getById(Long id) {
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    @Override
    public void deleteMenu(Long id) {
        if (!menuRepository.existsById(id)) {
            throw new RuntimeException("Menu not found");
        }
        menuRepository.deleteById(id);
    }
}