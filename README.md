# Kwetter Gateways

Backend gateways of my Kwetter project, a twitter clone created for a college assignment

## Technologies used
- Java
- Spring Boot
- gRPC to facilitate communication between microservices
- GitLab CI/CD to automatically test/build/deploy to docker

## Architecture overview
```mermaid
graph LR;
  Frontend-->UserGateway-->AuthService & LoggingService & MessageService & ProfileService;
```
