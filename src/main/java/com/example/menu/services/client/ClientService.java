package com.example.menu.services.client;

import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.entity.Client;
import com.example.menu.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(ClientRequestDTO data) {
        Client clientt = clientRepository.findByEmail(data.email());

        if (clientt == null) {
            Client cli = new Client();
            cli.setName(data.name());
            cli.setPhoneNumber(data.phoneNumber());
            cli.setEmail(data.email());
            return clientRepository.save(cli);
        } else {
            throw new RuntimeException("email already in use");
        }
    }

    @Override
    public Client login(ClientRequestDTO data) {
        if (this.clientRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }
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
