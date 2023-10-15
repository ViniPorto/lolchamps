<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/ViniPorto/lolchamps?color=%2304D361">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/ViniPorto/lolchamps">
  
  <a href="https://github.com/ViniPorto/lolchamps/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/ViniPorto/lolchamps">
  </a>

   <a href="https://github.com/ViniPorto/lolchamps/stargazers">
    <img alt="Stargazers" src="https://img.shields.io/github/stars/ViniPorto/lolchamps?style=social">
  </a>

  <a href="https://www.linkedin.com/in/vinicius-porto-9a1996209/">
    <img alt="Feito por Vinícius Porto" src="https://img.shields.io/badge/feito%20por-Vinícius Porto-%237519C1">
  </a>
  
</p>
<h1 align="center">
    Lol Champs
</h1>

<h4 align="center"> 
	✔  lolchamps ✨ Concluido ✔
</h4>

<h2 align="center">

![100%](https://progress-bar.dev/100)
    
</h2>


<p align="center">
 <a href="#-sobre-o-projeto">Sobre</a> •
 <a href="#-funcionalidades">Funcionalidades</a> •
 <a href="#-como-executar-o-projeto">Como executar</a> • 
 <a href="#-tecnologias">Tecnologias</a> • 
 <a href="#-autor">Autor</a> • 
</p>


## 💻 Sobre o projeto

Api REST desenvolvida para simular a consulta de campeões no client do Lol. 

Endpoint público para consultar dados dos campeões do jogo. Para utilizar os verbos HTTP além do GET, é necessário autenticar-se (apenas o usuário administrador).

Projeto referenciado no [repositório do clone do client do League Of Legends](https://github.com/ViniPorto/clone-league-of-legends) como a API que provê os dados para a aplicação frontend.

---

## ⚙ Funcionalidades

- [x] Consulta de campeões do League Of Legends: 
  - [x] Filtrar por nome ou role
  - [x] Ordenar por data de lançamento, nome, preço EA, preço RP
- [x] Usuário administrador pode gerenciar os dados dos campeões cadastrados

---

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html), [Maven](https://maven.apache.org/download.cgi), [MySQL](https://www.mysql.com/downloads/).

A API tem os valores de usuario e senha do banco respectivamente "root" e "12345678". Caso o usuario do banco seja diferente, crie variáveis de ambiente: "USERNAME_DB" e "PASSWORD_DB". Os valores das variáveis devem ser respectivamente o username e senha de um usuário do MySQL (pode ser user root).

#### 🎲 Rodando a API

```bash

# Clone este repositório
$ git clone git@github.com:ViniPorto/lolchamps.git

# Acesse a pasta do projeto no terminal/cmd
$ cd lolchamps

# Crie o build da API:
$ mvn clean package

# Acesse a pasta criada:
$ cd target

# Execute o arquivo através do comando:
$ java -jar lolchamps-0.0.1-SNAPSHOT.jar

# O servidor inciará na porta:8080 - acesse http://localhost:8080/champ

```
<p align="center">
  <a href="https://github.com/ViniPorto/lolchamps/blob/master/TestesInsomnia.json" target="_blank"><img src="https://insomnia.rest/images/run.svg" alt="Run in Insomnia"></a>
</p>

---

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

#### **Server**  ([Java](https://www.java.com/pt-BR/)  +  [Spring](https://spring.io/projects/spring-boot))

-   **[Spring Data JPA](https://github.com/spring-projects/spring-data-jpa)**
-   **[MySQL Connector J](https://github.com/mysql/mysql-connector-j)**
-   **[Bean Validation](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html)**
-   **[Spring Web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html)**
-   **[Lombok](https://github.com/projectlombok/lombok)**
-   **[Flyway](https://github.com/flyway/flyway)**
-   **[Spring Security](https://spring.io/projects/spring-security)**
-   **[auth0 Java JWT](https://github.com/auth0/java-jwt)**

> Veja o arquivo  [pom.xml](https://github.com/ViniPorto/lolchamps/blob/master/pom.xml)

#### [](https://github.com/tgmarinho/Ecoleta#utilit%C3%A1rios)**Utilitários**

-   Editor:  **[Visual Studio Code](https://code.visualstudio.com/)** 
-   Teste de API:  **[Insomnia](https://insomnia.rest/)**

---

## 💪 Como contribuir para o projeto

1. Faça um **fork** do projeto.
2. Crie uma nova branch com as suas alterações: `git checkout -b my-feature`
3. Salve as alterações e crie uma mensagem de commit contando o que você fez: `git commit -m "feature: My new feature"`
4. Envie as suas alterações: `git push origin my-feature`
> Caso tenha alguma dúvida confira este [guia de como contribuir no GitHub](./CONTRIBUTING.md)

---

## 🦸 Autor

<a href="https://github.com/ViniPorto">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/81120004?s=460&u=61b426b901b8fe02e12019b1fdb67bf0072d4f00&v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Vinícius Porto</b></sub></a> <a href="https://github.com/ViniPorto" title="Vinícius">🚀</a>
 <br />

---
