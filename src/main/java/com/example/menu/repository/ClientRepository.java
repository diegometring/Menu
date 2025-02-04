package com.example.menu.repository;

import com.example.menu.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long> {
    void deleteById(Long id);
}
