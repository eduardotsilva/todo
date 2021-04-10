# ToDo

# Projeto Fullstack com Spring Boot 2 e Angular 11

Utilizando H2 data base para teste do endPoint 

No arquivo "application.properties" deve possuir o conteúdo de perfil de test: spring.profiles.active=test

No arquivo "application-test.properties" deve possuir o conteúdo de configuração do h2dataBase:
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:file:~/test
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver

