package com.example.menu.dto.menu;

import com.example.menu.enums.Category;
import jakarta.validation.constraints.NotBlank;
import com.example.menu.entity.Menu;

public record MenuResponseDTO(Long id,
                              @NotBlank String name,
                              String image,
                              String description,
                              int price,
                              Category category,
                              boolean available) {

    public MenuResponseDTO(Menu menu) {
        this(menu.getId(), menu.getName(), menu.getImage(), menu.getDescription(), menu.getPrice(), menu.getCategory(), menu.isAvailable());
    }
}
