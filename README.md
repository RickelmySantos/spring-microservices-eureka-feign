# 🧩 Spring Boot Microservices - Eureka & Feign Demo

Este projeto é uma demonstração prática de um sistema com arquitetura de **microserviços** usando **Spring Boot**, **Spring Cloud Eureka** e **OpenFeign** para comunicação entre serviços.

---

## 🏗️ Arquitetura

O sistema é composto por 3 microsserviços:

| Serviço         | Porta | Responsabilidade                                     |
| --------------- | ----- | ---------------------------------------------------- |
| `eureka-server` | 8761  | Service discovery (registro e localização)           |
| `user-service`  | 8081  | Gerenciamento de usuários                            |
| `order-service` | 8082  | Gerenciamento de pedidos e consumo do `user-service` |

---

## 🔗 Comunicação

O `order-service` consome o `user-service` via **Feign**, usando o **nome registrado no Eureka**. Isso simula a comunicação entre microsserviços de forma desacoplada.

---

## 🚀 Como executar

Na pasta raiz do projeto execute o comando **docker compose up**, assim irar buildar e criar todos os containers

### Pré-requisitos

- Java 21
- Maven
- Docker
- Keycloak

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repo.git
cd seu-repo
```
