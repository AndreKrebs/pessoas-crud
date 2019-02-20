# CRUD DE PESSOAS (SPRING BOOT, ANGULAR e MYSQL)
O Documento descreve como configurar os ambientes de front-end e back-end do sistema e também a configuração do banco de dados MySQL.

## Banco de dados MySQL
O projeto possui o código sql para criação da base de dados e das tabelas e também possui um arquivo docker-compose.yml caso o desenvolvedor deseje criar uma base de dados em um container Docker.

### Docker Compose
Para iniciar o container Docker é necessário ter instalado o Docker Compose.
Com o Docker Compose instalado, basta acessar a pasta **./database-mysql/docker** pelo terminal e executar o comando `docker-compose up -d` e aguardar. Quando o container estiver rodando, o banco de dados podera ser acessado pelo endereço **localhost:3306** com usuário **root** e senha **12345**, esse container já inicia com a base de dados **crud-people-mysql**.

### Arquivo .sql
O arquivo sql serve tanto para executar em um banco de dados MySQL já configurado quanto para o MySQL do container Docker.
O arquivo fica em **./database-mysql/crud-people-mysql**, basta executar o script no banco de dados, porem, se for executar no container Docker, a primeira linha deve ser removida.

### MER do banco de dados
O diagrama do MER do banco de dados esta em **./database-mysql/mer-pessoas-e-dependentes.png**

## Back-end Spring Boot
O sistema de back-end foi desenvolvido com a tecnologia Spring Boot, para compilar e executar o sistema é necessário ter instalado o **JDK da versão 8 do Java** e o **Maven**.
Acesse a pasta **./pessoas-backend** pelo terminal, execute o comando `mvn clean package` para baixar as dependências e gerar o arquivo **.war**, aguarde o processo de compilação e em seguida execute o comando `java -jar target/pessoas-backend-0.0.1-SNAPSHOT.war`(Caso não tenha o arquivo .war com esse nome é só executar o unico .war dentro da pasta!).
Depois que o sistema iniciar ele estará disponivel no endereço **http://localhost:8080**.

As configurações de conexão de banco de dados podem ser alteras no arquivo **/src/main/resources/application.properties**.

## Front-end
O sistema de front-end foi desenvolvido em Angular 6, para executar o sistema é necessário possuir o **NodeJs** versão 8 ou superior e o gerenciador de pacotes **npm** atualizado e o **angular/cli** instalado globalmente(`npm install -g @angular/cli`).
Antes de iniciar o front-end é necessário instalar as dependências com o comando `npm install` na raiz da pasta **./front-end**, depois de instaladas as dependência é só iniciar o server do front com o comando `ng serve`.
O sistema pode ser acessado em http://localhost:4200
