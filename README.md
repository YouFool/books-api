# Books API 

## Objetivo
Construir um mecanismo de busca de livros.

### Requerimentos explícitos
* Usar Java no backend
* Desenvolver telas em HTML (pode ser usado frameworks)

---

### Stack
* Java 8
*  [Spring Framework](https://spring.io/) - Inicio rápido do projeto, vários módulos que aceleram o desenvolvimento da aplicação
    * [Spring Boot](https://spring.io/projects/spring-boot)
    * [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [Maven](https://maven.apache.org/)
* [Lombok](https://github.com/rzwitserloot/lombok) - Previne a geração de *boilerplate code* 
* [H2 | In-Memory Database](https://www.h2database.com/html/main.html) - Banco de dados em memória sem necessidade de configuração

### Get Started
Você deve possuir o [Java Development Kit 8](http://openjdk.java.net/install/) e, opcionalmente, o Apache Maven.

* Clone este repositório: `git clone https://github.com/YouFool/books-api.git`
* Entre na raiz do projeto: `cd books-api/`
* Gera o artefato com comando: `mvn package`
   * Alternativamente, caso não possua o Maven instalado: `mvnw package -DskipTests=true`
    
    
* Rode a aplicação executando: `java -jar target/books-0.0.1-SNAPSHOT.jar`
    * Outra opção, caso possua [Docker](https://www.docker.com/) instalado, basta rodar a aplicação via: `docker-compose build && docker-compose up` 
* A aplicação será servida por padrão no endereço `localhost:8085` por padrão
    * É possível alterar a porta da aplicação no arquivo `application.yml`
