package com.example.menu.services;

import com.example.menu.dto.ClientRequestDTO;
import com.example.menu.entity.Client;

import java.time.LocalDateTime;
import java.util.List;

public interface IClientService {
    Client createClient(ClientRequestDTO data);
    List<Client> getAllClient();
    void updateClient();
    void deleteClient(Long id);
}
