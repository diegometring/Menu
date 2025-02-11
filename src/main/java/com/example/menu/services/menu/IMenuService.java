package com.example.menu.services.menu;

import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.entity.Menu;

public interface IMenuService {
    Menu createMenu(MenuRequestDTO data);
    void deleteMenu(Long id);
    void updateMenu(Long id, MenuRequestDTO data);

}
