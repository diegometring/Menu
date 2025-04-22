package com.example.menu.services.menu;

import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.entity.Menu;

import java.util.List;

public interface IMenuService { // usado para facilitar a implementação das services, crio aqui primeiro definindo todas as services necessárias garantindo que não fique nada pra trás
    Menu createMenu(MenuRequestDTO data);
    Menu updateMenu(Long id, MenuRequestDTO data);
    List<Menu> getAll();
    Menu getById(Long id);
    void deleteMenu(Long id);
}