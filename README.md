<h1 align="center">
    <img alt="Ecommerce" src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/java/com/dio/crud.png" />
</h1>

<h3 align="center">
  REST API CRUD Digital Inovation- BackEnd - Spring Boot
</h3>

<p align="center">Criando um CRUD de Pessoa para Digital Inovation</p>

![GitHub repo size](https://img.shields.io/github/repo-size/JeffersonLuizCruz/financial)  ![Packagist License](https://img.shields.io/packagist/l/JeffersonLuizCruz/financial)  ![GitHub top language](https://img.shields.io/github/languages/top/JeffersonLuizCruz/financial)  ![GitHub language count](https://img.shields.io/github/languages/count/JeffersonLuizCruz/financial?label=Linguagem%20de%20Programa%C3%A7%C3%A3o)  ![GitHub followers](https://img.shields.io/github/followers/JeffersonLuizCruz?style=social)

<p align="center">
  <a href="#-sobre">Sobre o projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-diagrama">Diagrama de Classe</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-links">Links</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-contato">Contato</a>
</p>

## :page_with_curl: Sobre o projeto <a name="-sobre"/></a>

> É proposto o desenvolvimento de uma REST API para realização de um CRUD de uma entidade pessoa. 

O sistema permite o registro de usurio no bando de dados. É permitido o cadastro de um usário por CPF. A API não permite CPF iguais no bando de dados lançando uma exceção para o cliente. Os dados do usuário podem ser consultado por meio de uma listagem paginada e por seu código de identificação. Por fim, a aplicação permite as alterações dos dados cadastrados.


## :page_with_curl: Diagrama de Classe <a name="-diagrama"/></a>
<h1 align="center">
    <img alt="Ecommerce" src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/java/com/dio/diagramaClasse.png" />
</h1>

## Tecnologia:
- [x] Java 11<br>
- [x] Spring Boot 2.4.5<br>
- [x] Spring Data - JPA/Hibernate<br>
- [x] Banco de Dados PostgreSQL<br>

## Construção do Projeto:
- [x] Criação de Interface Service (garantir baixo acoplamento)<br>
- [x] CRUD (ORM Hibernate - Ambiente de teste)<br>
- [x] Exception Personalizada
- [x] Consulta Paginada
- [x] DTO

## Start do Projeto

```
server.error.include-stacktrace=never
server.port=8080

spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/dio
spring.datasource.username=postgres
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```

### [POST] Save status 200 ok
<h1 align="center">
    <img src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/java/com/dio/save.png" />
</h1>

