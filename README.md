# Online Store Backend

Este proyecto es el backend de una tienda online, compuesto por varios microservicios desarrollados en Java y un API Gateway en NestJS.

## Arquitectura

- **Microservicios Java**  
  Cada microservicio está desarrollado en Java siguiendo la arquitectura hexagonal (Ports & Adapters) y se conecta a su propia base de datos.  
  Microservicios:
  - `admin-service`
  - `auth-service`
  - `customer-service`
  - `product-service`

- **API Gateway (NestJS)**  
  El único punto de entrada expuesto al exterior es un API Gateway desarrollado en NestJS con arquitectura modular. Este gateway se encarga de enrutar las peticiones a los microservicios correspondientes.

## Tecnologías

- Java (Spring Boot)
- NestJS (Node.js)
- Arquitectura Hexagonal (Java)
- Arquitectura Modular (NestJS)
- Bases de datos relacionales

## Diagrama de Arquitectura

```plaintext
           +-------------------+
           |                   |
           |   Cliente/Front   |
           |                   |
           +---------+---------+
                     |
                     v
           +-------------------+
           |   API Gateway     |  (NestJS, Modular)
           +-------------------+
             |    |     |    |
             v    v     v    v
   +---------+ +---------+ +---------+ +---------+
   | admin   | | auth    | | customer| | product |
   | service | | service | | service | | service |
   | (Java,  | | (Java,  | | (Java,  | | (Java,  |
   | Hexag.) | | Hexag.) | | Hexag.) | | Hexag.) |
   +---------+ +---------+ +---------+ +---------+
```

