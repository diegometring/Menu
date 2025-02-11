package com.example.menu.dto.menu;

import com.example.menu.enums.Category;
import jakarta.validation.constraints.NotBlank;

public record MenuRequestDTO(@NotBlank String name,
                             String image,
                             String description,
                             int price,
                             Category category,
                             boolean available) {
}
