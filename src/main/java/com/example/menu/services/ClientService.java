package com.example.menu.services;

import com.example.menu.dto.ClientRequestDTO;
import com.example.menu.entity.Client;
import com.example.menu.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientService implements IClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(ClientRequestDTO data) {
        Client client = new Client();
        client.setName(data.name());
        client.setPhoneNumber(data.phoneNumber());
        client.setEmail(data.email());
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public void updateClient(Long id, ClientRequestDTO data) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        client.setName(data.name());
        client.setEmail(data.email());
        client.setPhoneNumber(data.phoneNumber());
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
