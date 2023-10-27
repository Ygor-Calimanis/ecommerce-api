# ecommerce

## Projeto de uma API de ecommerce feita em java utilizando springboot, maven e docker

[![SkillIcons](https://skillicons.dev/icons?i=java,spring,docker)](https://skillicons.dev)

#### API Docs

```
http://localhost:8083/swagger-ui.html
```

#### H2 Console

```
http://localhost:8083/h2-console
```

## Instruções de Implementação

No projeto "ecommerce" desenvolvido no Checkpoint 2:

Etidades:

Cliente

- id: Long (PK)
- nome: String(100) (NN)
- CEP: String(9)
- logradouro: String(100)
- numero: String(10)
- complemento: String(20)
- bairro: String(60)
- municipio: String(60)
- UF: String(2)
- data de dadastro: Instant (NN)
- ativo: boolean  (NN)

Pedido

- id: Long (PK)
- cliente: Cliente  (NN)
- data do pedido: Instant  (NN)
- data da entrega: Instant  (NN)
- valor total do pedido: BigDecimal
- situacao: Enum{ATIVO, CANCELADO, ENTREGUE} (NN)

Produto

- id: Long (PK)
- nome: String(100) (NN)
- data de dadastro: Instant (NN)

Item de Pedido

- id: Long (PK)
- pedido: Pedido (NN)
- produto: Produto (NN)
- quantidade: BigDecimal (NN)
- valor unitário: BigDecimal (NN)
- valor total: BigDecimal (NN)

2 - Criar scripts com massa de dados para o H2

3 - Criar camada de persistencia

4 - Criar endpoints CRUD usando DTOs para as entidades

- 4.1 Feature - CRUD Cliente
- 4.1.1 criar endpoint para listar clientes
```
git checkout -b feature/listar_cliente
git push --set-upstream origin feature/listar_cliente
```
- 4.1.2 criar endpoint para pesquisar cliente por ID
```
git checkout -b feature/4.1.2-cliente_por_id
git push --set-upstream origin feature/4.1.2-cliente_por_id
```
- 4.1.3 criar endpoint para criar cliente
- 4.1.4 criar endpoint para alterar cliente
- 4.1.5 criar endpoint para excluir cliente

## Referencias

- https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow
- http://h2database.com/html/functions.html
- https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
- https://www.baeldung.com/java-dto-pattern
- https://www.baeldung.com/java-instant-to-string
- https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization.using-basic-sql-scripts
