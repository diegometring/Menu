package com.example.menu.controller;

import com.example.menu.dto.menu.MenuRequestDTO;
import com.example.menu.dto.menu.MenuResponseDTO;
import com.example.menu.entity.Menu;
import com.example.menu.services.menu.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController //indica que esta classe é uma controller
@RequestMapping("/Menu")
public class MenuController {

    @Autowired //decorator para injeção de dependencia
    private MenuService menuService;

    @PostMapping("/createRecipe")
    public ResponseEntity<MenuResponseDTO> createMenu(@RequestBody @Valid MenuRequestDTO data) { //@Requestbody converte os dados json para o MenuRequestDTO e o @Valid aplica as validações feitas no dto
        Menu menu = menuService.createMenu(data); //chama a service
        MenuResponseDTO res = new MenuResponseDTO(menu);//cria um dto para resposta
        return ResponseEntity.status(HttpStatus.CREATED).body(res); //retorna um status 201 com o corpo recebido pelo dto
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MenuResponseDTO>> getAll() {
        List<Menu> menu = menuService.getAll(); //chamo a service para receber todos os itens do cardápio em uma lista
        List<MenuResponseDTO> resList = menu.stream()//uso stream para transformar menu em uma lista de dto
                .map(MenuResponseDTO::new) // a cada entidade será criado um dto separado
                .collect(Collectors.toList()); //coleta os dto's para uma nova lista
        return ResponseEntity.ok(resList); //retorna status 200 e com o body do resList
    }

    @GetMapping ("/getById/{id}")
    public ResponseEntity<MenuResponseDTO> getById(@PathVariable Long id) {
        Menu menu = menuService.getById(id); //chama a service
        MenuResponseDTO res = new MenuResponseDTO(menu); //cria um dto para resposta
        return ResponseEntity.ok(res); //retorna um status 200 com o corpo recebido pelo dto
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MenuResponseDTO> update(@PathVariable Long id, @RequestBody @Valid MenuRequestDTO data) { //pathvariable serve para extrair o valor e faz com que não seja mais necessário o uso de {} na url
        Menu menu = menuService.updateMenu(id, data); //chama a service
        MenuResponseDTO res = new MenuResponseDTO(menu); //cria um dto para resposta
        return ResponseEntity.ok(res); //retorna um status 200 com o corpo recebido pelo dto
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuService.deleteMenu(id); //chama a service
        return ResponseEntity.noContent().build(); // retorna 204, indicando que a operação foi feita e que não nada para ser retornado
    }
}
