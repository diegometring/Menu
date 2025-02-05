package com.example.menu.services;

import com.example.menu.entity.Menu;

public interface IMenuService {
    Menu createMenu();
    void deleteMenu(Long id);
    void updateMenu();

}
