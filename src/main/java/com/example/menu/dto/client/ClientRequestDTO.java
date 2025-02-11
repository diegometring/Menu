package com.example.menu.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientRequestDTO(@NotBlank @Size(max = 50) String name,
                               @Size(max = 20) int phoneNumber,
                               @NotBlank @Email String email,
                               @NotBlank @Size(min = 8) String password) {

}
