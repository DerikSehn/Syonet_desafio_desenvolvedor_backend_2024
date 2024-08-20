# Desafio backend - SYONET

Sistema desenvolvido para a realização da entrevista técnica da empresa Syonet, com o objetivo de testar as competências do desenvolvedor implementando um sistema de newsletter com vários critérios para qualificação.

## Visão Geral do Projeto

### Objetivo

Criar um sistema backend que permita o cadastro de clientes e newsletters e automatize o envio diário de newsletters por e-mail. O sistema deve fornecer uma API Web para o cadastro de clientes e newsletters, e enviar e-mails diários com as newsletters cadastradas e não processadas.

### Requisitos

1. **Cadastro de Clientes e Newsletters via API Web**

   - **Cliente:**
     - `nome`: string, obrigatório
     - `email`: string, obrigatório, deve ser um e-mail válido
     - `nascimento`: data, opcional, deve ser uma data válida
   - **Newsletter:**
     - `título`: string, obrigatório
     - `descrição`: string, obrigatório
     - `link`: URL, opcional, deve ser uma URL válida

2. **Envio de E-mails**

   - O sistema deve consultar os registros todos os dias às 08:00 e enviar e-mails para os clientes.
   - Os e-mails devem incluir as newsletters cadastradas e não processadas.
   - Se a data de nascimento de um cliente coincidir com a data atual, incluir uma mensagem de "Feliz Aniversário" no e-mail.

3. **Formato do E-mail**
   - **Assunto:** "Notícias do dia!"
   - **Corpo:**
     - Saudação personalizada: "Bom dia, `<nome_do_cliente>`!"
     - Mensagem de aniversário, se aplicável: "Feliz Aniversário!"
     - Lista de notícias do dia com:
       - Título clicável (se um link estiver disponível)
       - Descrição

### Estrutura do Sistema

1. **API Web:**

   - **Endpoints:**
     - `POST /clientes`: Cadastrar um novo cliente
     - `POST /noticias`: Cadastrar uma nova notícia
     - `GET /noticias`: Listar notícias não processadas
     - `GET /clientes`: Listar clientes

2. **Tecnologias Sugeridas:**
   - **Backend:** Java, Node.js (Java foi escolhido para este projeto)
   - **Banco de Dados:** PostgreSQL
   - **Framework:** Quarkus
   - **Containerização:** Docker

### Critérios de Avaliação

- Manutenibilidade
- Cumprimento dos requisitos
- Organização interna do projeto
- Qualidade da entrega e do código
- Validações de testes unitários cabíveis
- Escolhas de ferramentas auxiliares

## Configuração do Projeto

### Pré-requisitos

- Java 21 ou superior
- Docker
- Maven
- PostgreSQL

### Executando o Projeto Localmente

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/DerikSehn/Syonet_desafio_desenvolvedor_backend_2024.git
   cd Syonet_desafio_desenvolvedor_backend_2024
   ```

2. **Inicie o Container Docker do PostgreSQL:**

   ```bash
   docker run --name syonet-postgres -e POSTGRES_USER=seuusuario -e POSTGRES_PASSWORD=suasenha -e POSTGRES_DB=syonet -p 5432:5432 -d postgres
   ```

3. **Configure a Aplicação:**

   - Atualize o arquivo `application.properties` com suas credenciais do PostgreSQL.

4. **Compile e Execute a Aplicação:**

   ```bash
   ./mvnw clean package
   ./mvnw quarkus:dev
   ```

5. **Executando os Testes:**
   ```bash
   ./mvnw test
   ```

**Se necessário, configure o arquivo `application.properties` com os dados adequados ao seu ambiente:**

```properties
# Mailer
quarkus.mailer.host=smtp.gmail.com
quarkus.mailer.port=587
quarkus.mailer.start-tls=REQUIRED
quarkus.mailer.username=example@gmail.com
quarkus.mailer.password=password
quarkus.mailer.from=example@gmail.com
quarkus.mailer.auth-methods=DIGEST-MD5 CRAM-SHA256 CRAM-SHA1 CRAM-MD5 PLAIN LOGIN
quarkus.mailer.mock=false

# DataSource
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=quarkus
quarkus.datasource.password=quarkus
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:32771/quarkus
quarkus.datasource.jdbc=true

# Docker Image Build
quarkus.container-image.build=true
```

### Construindo a Imagem Docker

Para construir a imagem Docker para deploy, execute:

```bash
./mvnw clean package -Dquarkus.container-image.build=true
```

### Problemas Conhecidos

- Se você encontrar um erro `401 Unauthorized` durante o processo de construção da imagem Docker, verifique se as credenciais do seu registro Docker estão configuradas corretamente.
