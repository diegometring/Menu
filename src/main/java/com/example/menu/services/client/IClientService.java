package com.example.menu.services.client;

import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.entity.Client;

import java.util.List;

public interface IClientService {
    Client createClient(ClientRequestDTO data);
    Client login(ClientRequestDTO data);
    List<Client> getAllClient();
    Client updateClient(Long id, ClientRequestDTO data);
    void deleteClient(Long id);
}
