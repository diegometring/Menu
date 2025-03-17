package com.example.menu.repository;

import com.example.menu.entity.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long> {
    void deleteById(@NotNull Long id);
    Client findByEmail(@NotBlank @Email String email);
}
