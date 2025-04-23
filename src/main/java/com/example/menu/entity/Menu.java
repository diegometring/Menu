package com.example.menu.entity;

import com.example.menu.enums.Category;
import jakarta.persistence.*;


import java.util.List;

@Table(name ="menu")//defino o nome da tabela
@Entity //defino que esta classe será uma entidade
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//defino id como valor que irá se gerar automaticamente

    private Long id;
    private String name;
    private String image;
    private String description;
    private int price;
    private boolean available;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "menu")
    private List<Ordered> ordereds;

    //construtor com argumentos
    public Menu(Long id, String name, String image, String description, int price, boolean available, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.available = available;
        this.category = category;
    }

    public Menu() { //construtor sem argumentos

    }

    //daqui até o final são os getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
