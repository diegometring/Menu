package com.example.menu.services;

import com.example.menu.dto.MenuRequestDTO;
import com.example.menu.entity.Menu;

public interface IMenuService {
    Menu createMenu(MenuRequestDTO data);
    void deleteMenu(Long id);
    void updateMenu();

}
