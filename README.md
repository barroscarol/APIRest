# API - UOL


## Api - Para operações Crud com entidades Cidade e Clientes.

[CRUD]
    
    Obrigatórios:
    * Cadastrar Cidade.
    * Pesquisar Cidade pelo nome.

### Entidade Cidade

<br>

| Verbo  | Recurso                         | Descrição                                                                  |
| ------ | --------------------------------| -------------------------------------------------------------------------- |
| POST   | `/cidades`                      | Cadastrar uma nova cidade                                                  |
| GET    | `/cidades `                     | Retornar todas as cidades cadastradas                                      |
| GET    | `/cidades/nome?searchName`      | Busca cidade pelo nome (Case Sensitive)                                    |
| GET    | `/cidades/estado?searchName`    | Busca cidade pelo nome do estado (Case Sensitive)                          |
|        | Recursos Extras                 |                                                                            |
| GET    | `/cidades/search?searchName=`   | Busca nome da cidade e retorna com paginação                               |
| GET    | `/cidades/pesquisa?searchName=` | Busca nome da cidade por Estado e retorna com paginação.                   |
| GET    | `/cidades/id`                   | Retornar as cidades cadastradas por ID                                     |
| GET    | `/cidades/                     `| Retornar todas as cidades cadastradas                                      |
| GET    | `/cidades/page`                 | Retorna todas as cidades cadastradas com Paginação                         |

</br>




<b>[JSONFORMAT  - POST - Cadastrar nova Cidade]</b>

{
        <br>"nome": "Maragogi",</br>
        <br> "estado": "Alagoas"</br>
}

      
    Requisitos Funcionais :
    *  "nome" e "estado" precisam estar Preenchidos 
    *  "nome" e "estado" devem ter entre 2 e 30 caracteres. 
    
    
  
[CRUD]
    
    Obrigatórios :
    * Cadastrar cliente
    * Consultar cliente pelo nome
    * Consultar cliente pelo Id
    * Remover cliente
    * Alterar o nome do cliente

### Entidade Cliente

<br>

| Verbo  | Recurso                         | Descrição                                                                  |
| ------ | --------------------------------| -------------------------------------------------------------------------- |
| POST   | `/clientes`                     | Cadastrar um novo cliente                                                  |
| GET    | `/clientes/nome?searchName `    | Busca cliente pelo seu nome completo (Case Sensitive)                      |
| GET    | `/clientes/{id} `               | Busca cliente pelo seu ID                                                  |
| DELETE | `/clientes/{id} `               | Remove cliente pelo seu ID                                                 |
| UPDATE | `/clientes/{id} `               | Altera nome do cliente pelo seu ID                                         |
| Recursos Extras                          |                                                                            |
| GET    | `/clientes/search?searchName=`  | Busca cliente pelo nome e retorna em uma lista paginada                    |
| GET    | `/clientes/`                    | Retornar todos os clientes Cadastrados                                     |
| GET    | `/clientes/page`                | Retorna todos os clientes Cadastrados em uma lista paginada                |

</br>

<b>[JSONFORMAT  - POST - Inserir novo Cliente]</b>

 {        
      <br>  "nomeCompleto": "João ",</br>
      <br>  "sexo": "Masculino",</br>
      <br>  "dataDeNascimento": "10/07/1992",</br>
      <br>  "idade": 28,</br>
      <br>  "cidadeOndeReside": "Rio de Janeiro"</br>
 }

      
    Requisitos Funcionais :
    *  "nomeCompleto,sexo,dataDeNascimento e cidadeOndeReside" devem estar Preenchidos. 
    *  "dataDeNascimento" deve ser inserido no formato DD/MM/YYY . 
    *  "idade" deve ser inserido como número.

<b>[JSONFORMAT  - PUT - Alterar nome do cliente]</b>

 {        
      <br>  "nomeCompleto": "Maria "</br>

 }

      
    Requisitos Funcionais :
    *  "nomeCompleto" deve estar Preenchido. 
    *  "nomeCompleto" O nome do cliente deve conter entre 2 e 30 caracteres 
   

## Requisitos para a Instalação.
* Java 8 ou superior
* Git
* Maven
      
    Instalação :
    *  Git clone : https://github.com/barroscarol/APIRest.git
    *  Mvn clean install
    *  Maven Update nas dependencias do projeto.

## How
Acessos:

* `A API está  executada no servidor local na porta "8080", dessa forma, para todas as rotas serem acessadas localmente, use "http://localhost:8080/" antes do caminho da rota.`

* `A API foi documentada a partir do Swagger, personalizada com suas saídas e funcionalidades, para acesso use: http://localhost:8080/swagger-ui.html#/.`

* `Foi utilizado o banco de dados relacional h2 para acesso de tabelas http://localhost:8080/h2-console/`

* `Existe uma carga de dados na camada de teste, assim o h2 se inicializará com alguns dados de Clientes e Cidades (com finalidade de facilitar os testes)

* `em aplicattion.properties está configurado o padrão do banco de dados h2:` 

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


## Estrutura da API

A Api foi construida respeitando a arquitetura do Spring de construção e injeção de dependências em camadas.

 CompassoUolAPI 
```
CompassoUolAPI
├── src
│   ├── com.compassouol.config
|       ├── SwaggerConfig.java
│   ├── com.compassouol.domain
|       ├── Cidade.java
|       ├── Cliente.java
│   ├── com.compassouol.dto
│       ├── CidadeDTO.java
│       ├── ClienteDTO.java
|       ├── ClienteNewDTO.java
|   ├── com.compassouol.exceptions
│       ├── StandardError.java
│   ├── com.compassouol.repositories
│       ├── CidadeRepository.java
│       ├── ClienteRepository.java
│   ├── com.compassouol.resources
│       ├── CidadeResource.java
│       ├── ClienteResource.java
│   ├── com.compassouol.resources.exception
│       ├── FieldMessage.java
│       ├── HttpMessageNotReadableError.java
│       ├── ResourceExceptionHandler.java
│       ├── ValidationError.java
│   ├── com.compassouol.services
│       ├── CidadeService.java
│       ├── ClienteService.java
│       ├── ResourceExceptionHandler.java
│       ├── ValidationError.java
```
## Status
Project is: _in progress

## Contact
Created by [@barroscarol](https://github.com/barroscarol) - Feel free to talk !
