# Desafio: Sistema de Gerenciamento de Livros para uma Livraria Online

## 1. Configuração Inicial do Projeto
### Tarefa
Crie um projeto Spring Boot utilizando o Spring Initializr. Adicione as seguintes dependências: 
- Spring Web
- Spring Data JPA
- H2 Database (para desenvolvimento)
- Spring Security
- JWT
- Bean Validation
- Lombok
- Swagger

### Objetivo
Configurar o ambiente inicial do projeto.

---

## 2. Modelagem do Banco de Dados
### Tarefa
Modele as entidades principais do sistema:
- **Livro**: título, autor (referência para Autor), categoria (referência para Categoria), preço, data de publicação, estoque.
- **Autor**: nome, biografia.
- **Categoria**: nome, descrição.
- **Usuário**: nome, email, senha (criptografada), papel (admin, usuário).

### Objetivo
Definir as relações entre as entidades utilizando JPA.

---

## 3. CRUD para Entidades
### Tarefa
Implemente operações CRUD para as entidades Livro, Autor e Categoria.
- **Livro**: Criar, Ler, Atualizar, Deletar.
- **Autor**: Criar, Ler, Atualizar, Deletar.
- **Categoria**: Criar, Ler, Atualizar, Deletar.

### Objetivo
Criar repositórios, serviços e controladores REST para as operações CRUD.

---

## 4. Autenticação e Autorização com JWT
### Tarefa
Implemente a autenticação e autorização usando JWT.
- **Registro**: Endpoint para registrar novos usuários.
- **Login**: Endpoint para autenticar usuários e gerar token JWT.
- **Autorização**: Proteja endpoints sensíveis para que apenas usuários autenticados possam acessá-los.

### Objetivo
Garantir segurança no acesso às APIs.

---

## 5. Validação de Dados
### Tarefa
Adicione validação de dados utilizando Bean Validation (Hibernate Validator).
- **Livro**: Valide campos como título (não vazio), preço (positivo), estoque (não negativo).
- **Autor**: Valide campos como nome (não vazio).
- **Categoria**: Valide campos como nome (não vazio).

### Objetivo
Garantir que os dados inseridos sejam válidos.

---

## 6. Documentação com Swagger
### Tarefa
Configure o Swagger para documentar as APIs.
- Inclua descrições, parâmetros de entrada, exemplos de respostas e códigos de status.

### Objetivo
Facilitar o uso e teste das APIs através de uma documentação clara.

---

## 7. Regras de Negócio
### Tarefa
Implemente as seguintes regras de negócio:
- **Estoque**: Não permitir que o estoque de um livro fique negativo.
- **Preço**: Livros com preço inferior a um valor mínimo (ex: 10 unidades monetárias) devem ser rejeitados.
- **Autor Exclusivo**: Não permitir autores duplicados (baseado no nome).
- **Categoria Exclusiva**: Não permitir categorias duplicadas (baseado no nome).

### Objetivo
Assegurar que o sistema funcione de acordo com as regras de negócio especificadas.

---

## 8. Testes Unitários e de Integração
### Tarefa
Escreva testes unitários e de integração para os serviços e controladores.
- Use JUnit e Mockito para os testes unitários.
- Use @SpringBootTest para os testes de integração.

### Objetivo
Garantir a confiabilidade e estabilidade do sistema através de testes automatizados.

---

## 9. Deploy e Considerações Finais
### Tarefa
Configure o projeto para deployment.
- Pode ser no Heroku, AWS, ou qualquer outra plataforma de sua escolha.
- Utilize um banco de dados relacional (ex: PostgreSQL) para o ambiente de produção.

### Objetivo
Tornar o sistema acessível para uso real.

---

## Resumo do Projeto
Este projeto abrange desde a configuração inicial até o deployment, passando por modelagem de banco de dados, operações CRUD, segurança com JWT, validação de dados, documentação com Swagger, implementação de regras de negócio e testes automatizados. Isso proporcionará uma experiência completa e prática, testando e aprimorando seus conhecimentos nas tecnologias e conceitos mencionados.

---

## Dicas Extras
- **Boas práticas de código**: Mantenha o código limpo e organizado, utilize padrões de projeto quando apropriado.
- **Controle de versão**: Utilize Git para controle de versão do código.
- **Feedback contínuo**: Teste o sistema continuamente e busque feedback para melhorar e corrigir possíveis falhas.
