# Aplicação Web com Spring-boot 2.0 e Angular 8.0

O projeto está dividido em dois diretórios backend e frontend. O diretório backend contém aplicação servidor API Rest, desenvolvido na lingagem JAVA com SpringBoot 2.0 e banco de dados PostgreSQL. O diretório frontend contém a aplicação cliente, desenvolvido com o Framework Angular 8.0.

<h3>Requisitos para instalação do Backend-SpringBoot</h3>

Spring Boot 2.1.0.BUILD-SNAPSHOT requer [Java 8 ou 9](https://www.java.com/) e [Spring Framework 5.1.1.BUILD-SNAPSHOT](https://docs.spring.io/spring/docs/5.1.1.BUILD-SNAPSHOT/spring-framework-reference/) ou mais recente.

Será necessário também que o Apache Maven 3.3+ esteja instalado. Se você ainda não tem o Maven instalado, você pode seguir as instruções em [maven.apache.org](https://maven.apache.org/).

### instalação do Backend-SpringBoot

1. Primeiro clone o projeto digitando

```
git clone https://github.com/treepixel/springboot-angular.git
```

2. Edite as configurações do banco de dados em:

```
SisACTE/src/main/resources/applications.properties
```

Para que o PostgreSQL possa realizar as operações de georeferenciamento baixe e instale o postgis:

https://postgis.net/install/

Em seguida instale as extensões postgis, postgis_topology e unnacent no PostgreSQL.

3. Dentro do diretório Backend-SpringBoot é só digitar os comandos abaixo para rodar a aplicação:

```
mvn spring-boot:run
```

Ou você pode criar um executável Jar digitando

```
mvn package
```

O arquivo Jar será salvo dentro da pasta target, você pode executá-lo digitando:

```
java -jar target/sistema-denuncias-trabalho-escravo-0.0.1-SNAPSHOT.jar
```

### Requisitos para instalação do Frontend-AngularJs

A aplicação cliente requer o Node.Js na versão 8.12.0 ou mais recente. Se você ainda não tem instalado, você pode seguir as instruções em [nodejs.org](https://nodejs.org/en/)

### Instalação do Frontend-AngularJs

1. Caso não tenha clonado ainda o projeto, clone digitando:

```
git clone git@gitlab.sit.trabalho.gov.br:sit/SisACTE.git
```

2)Abra o arquivo _Frontend-AngularJs/app/config/consts.js_ e altere a propriedade "site" para o endereço url da aplicação servidor (Backend-SpringBoot)

```javascript
angular
  .module("myApp")
  .constant("consts", {
    appName: "Detrae/Sit",
    version: "1.0",
    owner: "Detrae/Sit",
    year: "2018",
    site: "http://localhost:8080", //Mude aqui para a url do servidor rest
    userKey: "_detrae_sit"
  })
  .run([
    "$rootScope",
    "consts",
    function($rootScope, consts) {
      $rootScope.consts = consts;
    }
  ]);
```

3. Digite o comando dentro do diretório Frontend-AngularJs

```
npm install
```

4. Digite o comando

```
npm install -g gulp
```

5. Por fim execute a aplicação digitando

```
npm run dev
```

ou

```
npm run production
```
