package com.example.menu.repository;

import com.example.menu.entity.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long> {
    void deleteById(Long id); //função para deletar por id
    Client findByEmail(@NotBlank @Email String email); //procura email para ver se não tem email já cadastrado quando for criar a conta
}
