package com.example.menu.services.client;

import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.dto.client.ClientTokenDTO;
import com.example.menu.entity.Client;
import com.example.menu.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    private AuthenticationManager authenticationManager;

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
    public Client login(@RequestBody @Valid ClientTokenDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            return clientRepository.findByEmail(data.email());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Long id, ClientRequestDTO data) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        client.setName(data.name());
        client.setEmail(data.email());
        client.setPhoneNumber(data.phoneNumber());
        return client;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
