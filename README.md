# Assistência técnica

## Sobre

Projeto desenvolvido em Java com o gerenciador de projetos Maven para realizar operações em um banco de dados PostgreSQL de uma assistência técnica.

## Ferramentas
- Java
- Maven
- PostgreSQL
- MySQL Workbench

## Diagrama entidade-relacionamento

O diagrama de entidade-relacionamento foi projetado na ferramenta MySQL Workbench e pode ser acessado [aqui](./eer_diagram).

![Diagrama entidade-relacionamento da assistência ténica](.github/assistencia_tecnica_eer_diagram.png)

## Banco de dados

Os comandos SQL para a criação do banco PostgreSQL e suas tabelas estão disponíveis [aqui](./src/main/resources/db/).

## Operações

Por meio deste projeto, é possível realizar as seguintes operações para cada tabela no banco de dados:

- `COUNT`: count()
- `INSERT`: insert(Object entity)
- `UPDATE`: update(Object entity)
- `DELETE`: delete(id)
- `SELECT`: select(id)
- `SELECT *`: selectAll(Integer id)
