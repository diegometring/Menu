## Pré requisitos

Java 17
Postgres 16

## 🛠️ Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/diegometring/Menu.git
```

### 2. Crie um database no postgres com o nome Menu e adicione o código abaixo no application.properties

```
spring.application.name=menu

spring.datasource.url=jdbc:postgresql://localhost:5432/menu
spring.datasource.username=postgres
spring.datasource.password=123
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=org.postgresql.Driver
```

### 3. Lista de arquivos que estão sendo usados para o trabalho

```
controller/ClientController
dto/client/ClientRequestDTO
dto/client/ClientResponseDTO
entity/Client
repository/ClientRepository
services/client/ClientService
services/client/IClientService

controller/MenuController
dto/menu/MenuRequestDTO
dto/menu/MenuResponseDTO
entity/Menu
repository/MenuRepository
services/menu/MenuService
services/menu/IMenuService

controller/StockController
dto/stock/StockRequestDTO
dto/stock/StockResponseDTO
entity/Stock
repository/StockRepository
services/stock/StockService
services/stock/IStockService
```

















# 🍽️ Menu - Sistema de Gerenciamento de Restaurante

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

## Descrição

Este é um sistema de gerenciamento de restaurantes desenvolvido em **Java** utilizando arquitetura MVC. O sistema
permite gerenciar mesas, cardápio, pedidos, reservas, estoque, pagamentos e feedback dos clientes, proporcionando uma
solução completa para a administração de um restaurante.



## Funcionalidades

### 1. **Gestão de Mesas**
- Cadastro de mesas.
- Controle de status (livre, ocupada, reservada).
- Visualização do mapa de mesas.

### 2. **Gestão de Cardápio**
- Cadastro de itens do cardápio (nome, descrição, preço, categoria).
- Atualização de disponibilidade dos itens.

### 3. **Gestão de Pedidos**
- Registro de pedidos por mesa.
- Acompanhamento do status do pedido (pendente, em preparo, pronto, entregue).
- Adição de múltiplos itens ao pedido.

### 4. **Gestão de Reservas**
- Agendamento de reservas por cliente.
- Controle de datas e horários das reservas.

### 5. **Gestão de Estoque**
- Controle de estoque dos itens do cardápio.
- Alertas para reposição de itens com baixo estoque.

### 6. **Gestão de Pagamentos**
- Registro de pagamentos (dinheiro, cartão, PIX).
- Cálculo automático do valor total.

### 7. **Feedback dos Clientes**
- Coleta de feedbacks com comentários e notas.
- Visualização de feedbacks por pedido.

### 8. **Relatórios**
- Relatórios de vendas, estoque e desempenho do restaurante.

## ⚙️ Pré-requisitos

- Java 21
- PostgreSQL 16


