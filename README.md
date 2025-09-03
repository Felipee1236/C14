# C14 - Sistema de Cadastro de Usuários (Java)

Este projeto demonstra um sistema simples de **cadastro de usuários** em Java, com persistência em arquivo JSON e testes automatizados utilizando JUnit 5.

---

## Funcionalidades

- Criação de usuários com campos **nome, idade e e-mail**.
- Persistência de listas de usuários em **arquivo JSON (`usuarios.json`)**.
- Testes automatizados que validam criação, alteração e salvamento de usuários.

---

## Estrutura do Código

O código principal está dividido em duas classes principais:

- **`Usuario.java`**  
  Representa o usuário com getters e setters para cada campo.

- **`UsuarioService.java`**  
  Responsável por salvar uma lista de usuários em arquivo JSON.  
  Funcionalidades:
  1. Recebe uma lista de usuários.
  2. Converte a lista para JSON.
  3. Salva no arquivo `usuarios.json`.
  4. Garante que listas nulas ou usuários com dados nulos não quebrem o sistema.

- **Testes (`UsuarioTest.java` e `UsuarioServiceTest.java`)**  
  Realizam validações de forma automatizada:
  - Testam criação de usuários com dados válidos e inválidos.
  - Testam setters e comportamento com valores nulos ou extremos.
  - Verificam o salvamento correto do JSON.
  - Garantem que métodos não lancem exceções inesperadas.
  - Após alterações de Vitor os testes de UsarioService não devem funcionar.

---

## Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/Felipee1236/C14.git
cd C14
mvn clean install
mvn exec:java
mvn test
