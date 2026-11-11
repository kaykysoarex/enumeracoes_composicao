# Estudos Java: Categorias de Classes

Anotações da aula **"Vamos falar um pouco de design"** do capítulo *Enumerações, composição*, do curso de Programação Orientada a Objetos com Java, do professor Nélio Alves.

## 📚 Conceitos

### A ideia central

- Em um sistema orientado a objetos, de modo geral, **"tudo" é objeto**.
- Por questões de design (**organização, flexibilidade, reuso, delegação**), as classes se dividem em **categorias**, cada uma com uma responsabilidade.

### As cinco categorias

| Categoria        | Responsabilidade (resumo)                                                                      |
| ---------------- | ---------------------------------------------------------------------------------------------- |
| **Entities**     | Representam os **dados do negócio**: `Order`, `Client`, `Product`                              |
| **Services**     | Concentram as **operações e regras** do sistema: `OrderService`, `AuthService`, `EmailService` |
| **Repositories** | Cuidam do **acesso aos dados** (salvar, buscar, apagar): `OrderRepository`                     |
| **Controllers**  | **Recebem as solicitações** do usuário ou de outros sistemas e as encaminham para os services  |
| **Views**        | A **apresentação**: o que o usuário vê (telas)                                                 |

> A aula apresenta os nomes e mostra exemplos de **Entities** e **Services**. As descrições de Controllers, Repositories e Views acima são o resumo do papel de cada um, e vão ficando mais claras quando o curso chegar ao Spring Boot.

### Exemplo da aula: Entities

```
Order ──tem vários──► OrderItem ──tem um──► Product
  │
  └──tem um──► Client

<<enum>> OrderStatus
```

São classes que guardam **dados e comportamentos do próprio objeto**, como `Order.total()` e `OrderItem.subTotal()`. Aqui aparecem a **composição** e o **enum** do mesmo capítulo.

### Exemplo da aula: Services e Repositories

```
<<interface>> CrudRepository<T, ID>
      ▲
OrderRepository          AuthService        EmailService
      ▲                      │                   ▲
OrderService ────────────────┴───────────────────┘
```

- `OrderService` usa um `OrderRepository` (para salvar e buscar pedidos) e um `EmailService` (para enviar e-mails).
- Cada classe faz **uma coisa**, e uma **delega** para a outra.

## 🔄 Como as categorias conversam

```
View ──► Controller ──► Service ──► Repository ──► Banco de dados
                           │
                       usa Entities (os dados que viajam entre as camadas)
```

Cada camada só conhece a **de baixo**. A tela não fala com o banco, e o banco não conhece a tela.

## 🧩 Aplicando no FrioOS

| Categoria        | No projeto                                                                             | Observação                                                                                           |
| ---------------- | -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| **Entities**     | `Cliente`, `Equipamento`, `ItemServico`, `OrdemServico`, `StatusOS`, `TipoEquipamento` | Pacote `entities`                                                                                    |
| **Services**     | `GestorOrdens`, `ExportadorJson`                                                       | Pacote `services`                                                                                    |
| **Repositories** | ainda não existe                                                                       | Hoje a lista de ordens fica dentro do `GestorOrdens`. Com arquivos ou banco, ela vira um repositório |
| **Controllers**  | o menu do `Program`                                                                    | No console, o `Program` mistura controller e view                                                    |
| **Views**        | o `Program` (console) e a pasta `web/` (HTML, CSS e JS)                                |                                                                                                      |

Esse mapa mostra um próximo passo natural: **separar a lista de ordens em uma classe repositório**, quando o curso chegar em interfaces e arquivos.

## 🎯 Por que organizar assim

- **Organização:** cada coisa tem um lugar certo.
- **Flexibilidade:** trocar a lista em memória por um banco muda só o repositório.
- **Reuso:** o mesmo service atende o console, o site e uma API.
- **Delegação:** cada classe faz uma tarefa e pede ajuda às outras para o resto.

## ➡️ O que vem pela frente

No Spring Boot, essas categorias viram anotações: `@Entity`, `@Service`, `@Repository` e `@Controller` (ou `@RestController`). Entender as categorias agora deixa o framework muito mais fácil de aprender.

## 🎯 Objetivo

Entender que um sistema orientado a objetos se divide em categorias de classes com responsabilidades diferentes, para organizar os meus projetos desde o começo.

## 🛠️ Tecnologias

- Java
- Visual Studio Code
- Git e GitHub

## 📈 Progresso

Este repositório será atualizado conforme eu avançar nas aulas, resolver exercícios e reforçar os conhecimentos adquiridos.

---

**Projeto de estudos pessoal, Sistemas de Informação.**     