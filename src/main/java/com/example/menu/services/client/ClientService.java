package com.example.menu.services.client;

import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.dto.client.ClientTokenDTO;
import com.example.menu.entity.Client;
import com.example.menu.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Client createClient(ClientRequestDTO data) {
        if (clientRepository.findByEmail(data.email()) != null) {
            throw new RuntimeException("email already in use");
        }

        Client cli = new Client();
        cli.setName(data.name());
        cli.setPhoneNumber(data.phoneNumber());
        cli.setEmail(data.email());
        cli.setPassword(passwordEncoder.encode(data.password()));
        return clientRepository.save(cli);
    }

    @Override
    public Client login(ClientTokenDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            Client client = clientRepository.findByEmail(data.email());
            if (client == null) {
                throw new RuntimeException("Client not found");
            }
            return client;
        } catch (Exception e) {
            throw new RuntimeException("authentication failure");
        }
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Long id, ClientRequestDTO data) {
        Client clientt = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

        Client client = clientRepository.findByEmail(data.email());
        if (client != null && !client.getId().equals(id)) {
            throw new RuntimeException("email is already in use");
        }
        client.setName(data.name());
        client.setEmail(data.email());
        client.setPhoneNumber(data.phoneNumber());
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found");
        }
        clientRepository.deleteById(id);
    }
}
