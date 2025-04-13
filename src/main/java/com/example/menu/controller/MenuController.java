package com.example.menu.controller;

import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.dto.menu.MenuResponseDTO;
import com.example.menu.entity.Menu;
import com.example.menu.services.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping
    public ResponseEntity<MenuResponseDTO> createMenu(MenuRequestDTO data) {
        try {
            Menu menu = menuService.createMenu(data);
            MenuResponseDTO res = new MenuResponseDTO(
                    menu.getId(),
                    menu.getName(),
                    menu.getPrice()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (RuntimeException e) {
            throw new RuntimeException("Unable to create recipe");
        }
    }
}
