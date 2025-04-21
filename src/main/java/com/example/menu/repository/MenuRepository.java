package com.example.menu.repository;

import com.example.menu.entity.Menu;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository <Menu, Long> {
    Menu findByName(@NotBlank String name);
}
