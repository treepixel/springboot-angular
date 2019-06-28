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
## Modo de Produção ##
backend/src/main/resources/applications.properties

## Modo de Desenvolvimento ##
backend/src/main/resources/applications-dev.properties
```
Exemplo:

```
spring.datasource.url={url do banco Postgres}
spring.datasource.username={ usuário }
spring.datasource.password={ senha }
spring.datasource.driverClassName=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.datasource.sqlScriptEncoding=UTF-8
#spring.profiles.active=dev (Caso queira executar no modo dev apague #)
```

3. Dentro do diretório backend é só digitar os comandos abaixo para rodar a aplicação:

```
mvn spring-boot:run ==> A aplicação irá estar disponível em http://localhost:8080
```



### Requisitos para instalação do Frontend

A aplicação cliente requer o Node.Js na versão 10.0 ou mais recente. Se você ainda não tem instalado, você pode seguir as instruções em [nodejs.org](https://nodejs.org/en/). Além disso, verifique a versão do npm se é igual ou mais recente que 6.0. 

### Instalação do Frontend

1. Caso não tenha clonado ainda o projeto, clone digitando:

```
git clone https://github.com/treepixel/springboot-angular.git
```

2. Caso esteja rodando a aplicação em uma porta diferente, abra o arquivo frontend/src/app/services/api.service.ts  e altere o valor de "API_URL" para o endereço url da aplicação servidor (Backend-SpringBoot)

```javascript
...

export class ApiService {

  constructor(private http: HttpClient) { }

  readonly API_URL = 'http://localhost:8080/api';

  addProduct (product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.API_URL}/products`, product, httpOptions)
  }

...
```

3. Dentro da pasta frontend digite o comando abaixo para instalar as dependências:

```
npm install
```

4. Depois de instaladas as dependências inicie a aplicação

```
npm start ou ng serve
```

5. Após a inicialização abra o seu navegador na url abaixo para visualizar a aplicação:

```
http://localhost:4200
```


