package com.example.menu.dto.client;

import com.example.menu.entity.Client;

public record ClientResponseDTO(Long id, String name, String email, int phoneNumber) {

    public ClientResponseDTO(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getPhoneNumber());
    }

}


