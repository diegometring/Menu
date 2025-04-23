package com.example.menu.services.client;

import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.dto.client.ClientTokenDTO;
import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.entity.Client;
import com.example.menu.entity.Menu;
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
    private ClientRepository clientRepository; //injeção de dependencia

    @Autowired
    private AuthenticationManager authenticationManager; //injeção de dependencia

    @Autowired
    private PasswordEncoder passwordEncoder; //injeção de dependencia

    @Override
    public Client createClient(ClientRequestDTO data) {
        if (clientRepository.findByEmail(data.email()) != null) {//faz a busca pelo email antes de criar o user
            throw new RuntimeException("email already in use");
        }
        Client cli = new Client(); //cria uma nova entidade e define os atributos com os dados recebidos do dto
        cli.setName(data.name());
        cli.setPhoneNumber(data.phoneNumber());
        cli.setEmail(data.email());
        cli.setPassword(passwordEncoder.encode(data.password())); //codifica a senha
        return clientRepository.save(cli); //retorna a entidade salva no banco
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
    } //retorna todas as receitas em uma lista

    @Override
    public Client updateClient(Long id, ClientRequestDTO data) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found")); //busca a entidade menu pelo id e se não for encontrada da um erro

        client.setName(data.name());
        client.setEmail(data.email());
        client.setPhoneNumber(data.phoneNumber());
        return clientRepository.save(client); //retorna a entidade salva no banco
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found")); //retorna a entidade salva no banco, se não for encontrado recebe uma mensagem de erro
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) { // verifica se o id que está sendo solicitado pra deletar existe no banco
            throw new RuntimeException("Client not found");
        }
        clientRepository.deleteById(id); //deleta pelo id
    }
}
