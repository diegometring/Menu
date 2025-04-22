package com.example.menu.repository;

import com.example.menu.entity.Menu;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MenuRepository extends JpaRepository <Menu, Long> {
    Optional<Menu> findByName(@NotBlank String name); //cria uma nova busca no repository
}
