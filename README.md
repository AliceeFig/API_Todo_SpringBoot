# 📋 Todo List - Spring Boot

Um projeto simples de **lista de tarefas (Todo List)** desenvolvido com **Java 17** e **Spring Boot** para o minicurso **Construindo uma API com spring Boot** da SNCT.

## 🚀 Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## ⚙️ Como rodar o projeto

### 1. Clonar o repositório
```
git clone https://github.com/seu-usuario/nome-do-repo.git
cd nome-do-repo
```
---

### 2. Configurar banco de dados
```
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Como rodar o projeto 
```
mvn spring-boot:run
```

---

### 📌 Endpoints da API
---
## Criar uma tarefa

POST /api/todos
Body (JSON):

{
  "title": "Estudar Spring Boot"
}
---
## Listar todas as tarefas

GET /api/todos
----
## Atualizar uma tarefa

PUT /api/todos/{id}
Body (JSON):

{
  "title": "Estudar Spring Boot - atualizado",
  "completed": true
}
---
## Deletar uma tarefa

DELETE /api/todos/{id}
---

### 🧪 Testando com o Postman
---

## Abra o Postman e crie uma nova Collection chamada Todo List.

##Adicione as seguintes requisições:

POST http://localhost:8080/api/todos
→ Envie no Body (JSON) o título da tarefa.

GET http://localhost:8080/api/todos
→ Retorna todas as tarefas cadastradas.

PUT http://localhost:8080/api/todos/{id}
→ Atualiza uma tarefa específica passando o id.

DELETE http://localhost:8080/api/todos/{id}
→ Remove uma tarefa do banco.

# Clique em Send em cada requisição e observe as respostas no painel inferior do Postman.

## ✨ Autor
#AliceeFig

