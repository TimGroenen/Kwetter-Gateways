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
  click Frontend "https://www.github.com/TimGroenen/Kwetter-Frontend" "Goto Frontend repo"
  click UserGateway "https://www.github.com/TimGroenen/Kwetter-Gateways" "Goto Gateway repo"
  click AuthService "https://www.github.com/TimGroenen/Kwetter-Microservices" "Goto Microservices repo"
  click LogginService "https://www.github.com/TimGroenen/Kwetter-Microservices" "Goto Microservices repo"
  click MessageService "https://www.github.com/TimGroenen/Kwetter-Microservices" "Goto Microservices repo"
  click ProfileService "https://www.github.com/TimGroenen/Kwetter-Microservices" "Goto Microservices repo"
```
