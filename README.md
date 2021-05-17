<h1 align="center">
    <img alt="Ecommerce" src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/resources/templates/crud.png" />
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

O sistema permite o registro de usurio no bando de dados. É permitido o cadastro de um usuário por CPF. A API não permite CPF iguais no bando de dados lançando uma exceção para o cliente. Os dados do usuário podem ser consultado por meio de uma listagem paginada e por seu código de identificação. Por fim, a aplicação permite as alterações dos dados cadastrados.


## :page_with_curl: Diagrama de Classe <a name="-diagrama"/></a>
<h1 align="center">
    <img alt="Ecommerce" src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/resources/templates/diagramaClasse.png" />
</h1>

## Tecnologia:
- [x] Java 11<br>
- [x] Spring Boot 2.4.5<br>
- [x] Spring Data - JPA/Hibernate<br>
- [x] Banco de Dados PostgreSQL<br>
- [x] Apache Maven 3.6.0
- [x] JUnit5, Mockito
- [ ] Heroku

## Construção do Projeto:
- [x] Criação de Interface Service (garantir baixo acoplamento)<br>
- [x] CRUD (ORM Hibernate - Ambiente de teste)<br>
- [x] Exception Personalizada
- [x] Consulta Paginada
- [x] DTO / ModelMapper
- [x] Teste Unitário e Teste de Integração(JUnit5 e Mockito)

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

### [POST] save     | status 200 OK
[POST] - https://application-crudperson-api.herokuapp.com/
#### Body:
`
{
    "firstName": "Jeff",
    "lastName": "Luiz",
    "cpf": "85731310041",
    "birthDate": "22/04/2021",
    "phones": [
        {
            "number": "988053101",
            "type": "COMMERCIAL"
        }
    ]
}
`

<h1 align="center">
    <img src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/resources/templates/save.png" />
</h1>

### [POST] save     | status 400 BAD REQUEST
<h1 align="center">
    <img src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/resources/templates/saveException.png" />
</h1>

### [PUT] update    | status 200 OK
<h1 align="center">
    <img src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/resources/templates/update.png" />
</h1>

### [GET] findById  | status 200 OK
<h1 align="center">
    <img src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/resources/templates/getById.png" />
</h1>

### [GET] findById  | status 404 NOT FOUND
<h1 align="center">
    <img src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/resources/templates/getByIdException.png" />
</h1>

### [GET] listAll   | status  200 OK | CONSULTA PAGINADA
<h1 align="center">
    <img src="https://github.com/JeffersonLuizCruz/crudperson/blob/main/src/main/resources/templates/pageRequest.png" />
</h1>
