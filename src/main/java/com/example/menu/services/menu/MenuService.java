package com.example.menu.services.menu;

import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.entity.Menu;
import com.example.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuService implements IMenuService{

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
    public void deleteMenu(Long id) {
        menuRepository.findById(id).ifPresentOrElse(menuRepository::delete, () -> {
            throw new RuntimeException("Menu not found with id: " + id);
        });
    }

    @Override
    public void updateMenu(Long id, MenuRequestDTO data) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setName(data.name());
        menu.setImage(data.image());
        menu.setDescription(data.description());
        menu.setPrice(data.price());
        menu.setCategory(data.category());
        menu.setAvailable(data.available());
        menuRepository.save(menu);
    }

    @Override
    public Menu addOrder(Long id, MenuRequestDTO data) {
        return null;
    }
}