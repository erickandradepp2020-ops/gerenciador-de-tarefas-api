# 📝 Gerenciador de Tarefas API

Uma API REST completa para criar, listar, atualizar e deletar tarefas (To-Do List), desenvolvida para consolidar conhecimentos no ecossistema Spring e banco de dados relacional.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3 (Web, Data JPA)
- PostgreSQL (Banco de Dados)
- Hibernate (Mapeamento Objeto-Relacional)
- Postman (Testes de API)

## ⚙️ Como Executar o Projeto

1. Crie um banco de dados no PostgreSQL chamado `gerenciador_de_tarefas`.

2. Clone este repositório:

```bash
   git clone https://github.com/erickandradepp2020-ops/gerenciador-de-tarefas-api.git
```

3. Na pasta `src/main/resources`, crie um arquivo chamado `application-local.properties` e adicione a sua senha do banco:

```properties
   spring.datasource.password=sua_senha_aqui
```

4. Execute o projeto usando a sua IDE (IntelliJ) ou via terminal.

## 🛣️ Endpoints da API

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/tarefas` | Cria uma nova tarefa |
| `GET` | `/tarefas` | Lista todas as tarefas cadastradas |
| `GET` | `/tarefas/{id}` | Busca uma tarefa específica pelo ID |
| `PUT` | `/tarefas/{id}` | Atualiza os dados de uma tarefa existente |
| `DELETE` | `/tarefas/{id}` | Remove uma tarefa do banco de dados |
