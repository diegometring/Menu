package com.example.menu.services.client;

import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.dto.client.ClientResponseDTO;
import com.example.menu.dto.client.ClientTokenDTO;
import com.example.menu.entity.Client;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IClientService {
    Client createClient(ClientRequestDTO data);
    Client login(ClientTokenDTO data);
    List<Client> getAllClient();
    Client updateClient(Long id, ClientRequestDTO data);
    void deleteClient(Long id);
}
