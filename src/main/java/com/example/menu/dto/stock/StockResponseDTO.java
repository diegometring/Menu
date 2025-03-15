package com.example.menu.dto.stock;

import jakarta.validation.constraints.NotBlank;

public record StockResponseDTO(Long id,
                               @NotBlank String nameProduct,
                               @NotBlank int quantity,
                               @NotBlank double unitPrice) {
}
