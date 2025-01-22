# Sistema de Cadastro de Funcionários

Este sistema foi desenvolvido em Java para realizar operações CRUD (Criar, Ler, Atualizar e Deletar) em um banco de dados MySQL. Ele permite que os funcionários sejam cadastrados, consultados e excluídos.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada no desenvolvimento do sistema.
- **JDBC**: Para conectar o Java ao banco de dados MySQL.
- **MySQL**: Banco de dados utilizado para armazenar os dados dos funcionários.

## Funcionalidades

- **Cadastrar Funcionário**: Permite cadastrar novos funcionários.
- **Consultar Funcionários**: Exibe todos os funcionários cadastrados no banco de dados.
- **Deletar Funcionário**: Permite excluir um funcionário a partir do seu ID.

## Estrutura do Banco de Dados

A base de dados contém duas tabelas principais: **departamento** e **funcionario**.

### Tabelas

#### 1. Tabela `departamento`

- **idDepartamento**: Identificador único do departamento (chave primária).
- **nome**: Nome do departamento.
- **sigla**: Sigla do departamento.

#### 2. Tabela `funcionario`

- **idFuncionario**: Identificador único do funcionário (chave primária).
- **nome**: Nome do funcionário.
- **matricula**: Matrícula do funcionário.
- **departamento_FK**: Referência ao departamento do funcionário (chave estrangeira referenciando a tabela `departamento`).

## Script SQL para Criação do Banco de Dados

```sql
CREATE DATABASE db_java;

USE db_java;

CREATE TABLE departamento (
    idDepartamento int NOT NULL auto_increment,
    nome varchar(45) NOT NULL,
    sigla varchar(45) NOT NULL,
    PRIMARY KEY (idDepartamento)
);

CREATE TABLE funcionario (
    idFuncionario int NOT NULL,
    nome varchar(45) NOT NULL,
    matricula int NOT NULL,
    departamento_FK int,
    CONSTRAINT FK_Departamento FOREIGN KEY (departamento_FK) REFERENCES departamento(idDepartamento)
);

-- Inserção de dados
INSERT INTO departamento(nome, sigla) VALUES
    ("Desenvolvimento", "DEV"),
    ("Qualidade", "QA"),
    ("Engenharia", "ENG");

INSERT INTO funcionario(idFuncionario, nome, matricula, departamento_FK) VALUES
    (1, "Maria", 2513, 3),
    (2, "João", 3640, 1),
    (3, "Marta", 1010, 2);

-- Consulta de todos os funcionários

SELECT * FROM funcionario;
````
## Instruções para Execução

### 1. Banco de Dados

Certifique-se de ter o MySQL instalado. Após isso, crie o banco de dados `db_java` e execute o script SQL fornecido no arquivo para criar as tabelas `departamento` e `funcionario`.

- **Banco de Dados**: `db_java`
- **Tabelas**:
  - `departamento`
  - `funcionario`

### 2. Configuração da Conexão

A classe **Conexao** no código contém as credenciais e configurações de conexão com o banco de dados:

```java
private String servidor = "localhost";
private String banco = "db_java";
private String user = "root";
private String password = "gtr3253";  // Alterar se necessário ou uma senha de acordo com seu servidor local
````
## 3. Executando o Sistema

Compile o projeto utilizando a IDE de sua preferência ou via linha de comando com `javac`.

Execute a classe **App** para rodar o sistema:

```bash
java br.com.fecaf.App
````
## 4. Menu de Operações

Quando o sistema for iniciado, o menu será exibido com as seguintes opções:
- `1 - Listar funcionários`
- `2 - Deletar funcionário`
- `3 - Cadastrar funcionário`
- `4 - Sair`


Escolha a opção desejada digitando o número correspondente.

### Exemplo de Execução

Após rodar o sistema, o menu estará disponível para interagir com as operações do sistema de cadastro de funcionários.

---

## Estrutura do Código

O código-fonte está estruturado em pacotes e classes. A seguir, uma breve descrição das principais partes do sistema:

### Pacote `br.com.fecaf`

- **App**: Classe principal que executa o sistema.
- **controller**: Contém as classes responsáveis pela lógica de controle, como a manipulação dos dados no banco de dados.
- **model**: Contém as classes que representam os dados, como a classe `Funcionario`.
- **database**: Contém a classe responsável pela conexão com o banco de dados.

### Classes Principais

1. **App.java**  
   Classe que executa o sistema e chama o menu de operações.

2. **FuncionarioController.java**  
   Responsável por realizar as operações CRUD no banco de dados, como cadastrar, consultar e deletar funcionários.

3. **Menu.java**  
   Exibe o menu de operações para o usuário e chama as funções apropriadas com base na escolha do usuário.

4. **Funcionario.java**  
   Classe modelo que representa os dados do funcionário, como ID, nome, matrícula e departamento.

5. **Conexao.java**  
   Classe responsável pela configuração e conexão ao banco de dados MySQL.

---

## Conclusão

Este sistema simples de cadastro de funcionários em Java com MySQL demonstra a utilização de JDBC para conectar e manipular dados em um banco de dados relacional. É uma base para sistemas mais complexos, podendo ser expandido com mais funcionalidades e melhorias.


