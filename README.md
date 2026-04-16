# Motor para Análise de Crédito

Aplicação backend sendo desenvolvida como parte de PDI com as tecnologias:
- Java
- Spring Boot
- Arquitetura Hexagonal
- Padrões de Projeto
- Banco H2, posteriormente será migrado para PostgreSQL

A aplicação será iniciada com regras simples e evoluindo com o tempo, à princípio serão feitas validações de 
idade e renda, consultas ao score e restrições serão feitas através de mocks, que retornarão informações
randômicas, mas a arquitetura ficará pronta para conexão com APIs oficiais.

--- 

## Atividades PDI:

### Semana 28/03-01/04

- [x] Geração do projeto
- [x] Definição inicial da estrutura
- [x] Definição dos domínios Client e Score
- [x] Implementação de services e repositories (inicial)


### Até 05/04:

- [x] Refatorar nomes dos pacotes para inglês;
- [x] Finalizar service/repository de clientes;
  - [ ] Avaliar criação do Cliente com Factory (ClienteDto -> Cliente)
- [x] Migração para PostgreSQL;


### Semana 06-09/04:

- [x] Criar endpoint para execução das regras:
  - [x] recebe um cpf, recupera cadastro, executa regras e retorna 'positivo' ou 'negativo';
- [x] Início do desenvolvimento das regras (Chain of Responsability):
  - [x] Validar idade:
    - idade < 18 retorna 'negativo';
    - caso contrário retorna 'positivo';
  - [x] Validar renda:
    - renda < $1.600,00 retorna 'negativo';
    - caso contrário retorna 'positivo';
- Concluído em 16/04/2026

### Semana 10-16/04:

- [x] Simular chamada ao Serasa:
  - [x] Retornar score aleatório;
  - [x] Retornar 'com restrição' aleatório;
  - [x] Gravar informação na tabela SCORE;
- [x] Utilização de record para DTOs;
- Concluído em 16/04/2026

### Próximas etapas:
- [ ] Testes unitários;
- [ ] Revisar arquitetura;

---

## TODO
- estudar implementação de migrações com flyway

---
2026-03

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)