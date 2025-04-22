package com.example.menu.dto.stock;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StockRequestDTO(
        @NotBlank String nameProduct,
        @Min(0) int quantity,
        @NotNull double unitPrice
) {
}