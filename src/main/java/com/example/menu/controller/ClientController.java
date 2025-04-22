package com.example.menu.controller;

import com.example.menu.dto.client.ClientResponseDTO;
import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.dto.client.ClientTokenDTO;
import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.dto.menu.MenuResponseDTO;
import com.example.menu.entity.Client;
import com.example.menu.entity.Menu;
import com.example.menu.services.client.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Client")
public class ClientController {

    @Autowired // decorator para injeção de dependencia
    ClientService clientService;

    @PostMapping("/createAccount") //
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody @Valid ClientRequestDTO data) {
        Client client = clientService.createClient(data);
        ClientResponseDTO res = new ClientResponseDTO(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(res); //retorno o body com os valores recebidos
    }

    @PostMapping("/login")
    public ResponseEntity<ClientResponseDTO> login(@RequestBody @Valid ClientTokenDTO data) {
        Client client = clientService.login(data); // chamo o clientService
        ClientResponseDTO res = new ClientResponseDTO(client); // atualizo os valores recebidos pelo clientTokenDTO
        return ResponseEntity.ok(res); //retorno um status ok e o body
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientResponseDTO>> getAll() {
        List<Client> clients = clientService.getAllClient(); //chamo a service para receber todos os clients em uma lista
        List<ClientResponseDTO> resList = clients.stream()
                .map(ClientResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resList);
    }

    @GetMapping ("/getById/{id}")
    public ResponseEntity<ClientResponseDTO> getById(@PathVariable Long id) {
        Client client = clientService.getById(id);
        ClientResponseDTO res = new ClientResponseDTO(client);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody @Valid ClientRequestDTO data) {
        try {
            Client updatedClient = clientService.updateClient(id, data);
            return ResponseEntity.ok(updatedClient);
        } catch (RuntimeException e) {
            throw new RuntimeException("Client not found"); // Captura a exceção "Client not found" do ClientService
        } catch (Exception e) {
            throw new RuntimeException("Outras exceptions");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
