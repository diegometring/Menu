package com.example.menu.dto;

import com.example.menu.enums.Category;
import jakarta.validation.constraints.NotBlank;

public record MenuRequestDTO(@NotBlank String name,
                             String description,
                             int price,
                             Category category,
                             boolean available) {
}
