# 📚 Estruturas de Dados — Resumo de Estudos

> **Disciplina:** Estruturas de Dados  
> **Professor:** Alexandre Zamberlan — alexz@ufn.edu.br — [github.com/alexandrezamberlan](https://github.com/alexandrezamberlan)  
> **Linguagem principal:** Java  
> **Objetivo:** Organizar, armazenar e manipular dados na memória de forma eficiente.

---

## 📑 Sumário

- [📌 O que são Estruturas de Dados?](#-o-que-são-estruturas-de-dados)
- [🧱 Estruturas Físicas vs. Abstratas](#-estruturas-físicas-vs-abstratas)
- [🗂️ Implementações por Linguagem](#️-implementações-por-linguagem)
- [1. 📋 Listas — `ArrayList`](#1--listas--arraylist)
- [2. 🚶 Filas — `Queue`](#2--filas--queue)
- [3. 📚 Pilhas — `Stack`](#3--pilhas--stack)
- [🧬 Hierarquia das Coleções Java e Polimorfismo](#-hierarquia-das-coleções-java-e-polimorfismo)
- [⚖️ Comparativo: `ArrayList` vs `LinkedList`](#️-comparativo-arraylist-vs-linkedlist)
- [4. 🔢 Matrizes Especiais](#4--matrizes-especiais)
- [🌐 Estruturas Não Lineares (Visão Geral)](#-estruturas-não-lineares-visão-geral)
- [🚀 Evolução Prática](#-evolução-prática)
- [📎 Estrutura de Arquivos do Repositório](#-estrutura-de-arquivos-do-repositório)

---

## 📌 O que são Estruturas de Dados?

Estrutura de Dados é uma área da **Ciência da Computação** que estuda formas de **organizar, armazenar e manipular dados na memória do computador** de maneira eficiente.

O objetivo é desenvolver **algoritmos capazes de gerenciar dados da melhor forma possível**, permitindo:

- ➕ Inserção de dados
- ➖ Remoção de dados
- 🔍 Busca de informações
- 📊 Organização e ordenação de dados

---

## 🧱 Estruturas Físicas vs. Abstratas

### Estruturas Físicas

Dependem da linguagem de programação. Representam como os dados são armazenados diretamente na memória.

Exemplos: `int`, `float`, `char`, `String`, vetores (arrays), matrizes.

### Estruturas Abstratas (EDA)

São conceituais e independentes da linguagem. Representam modelos de organização de dados.

| Estrutura | Descrição |
|-----------|-----------|
| **Lista** | Sequência dinâmica de elementos |
| **Pilha (Stack)** | LIFO — último a entrar, primeiro a sair |
| **Fila (Queue)** | FIFO — primeiro a entrar, primeiro a sair |
| **Árvore (Tree)** | Estrutura hierárquica em nós |
| **Grafo (Graph)** | Vértices conectados por arestas |

---

## 🗂️ Implementações por Linguagem

| Linguagem | Lista |
|-----------|-------|
| C++ | `vector`, `list` |
| Java | `ArrayList`, `LinkedList` |
| C# | `List` |
| Python | `list` |

---

# 1. 📋 Listas — `ArrayList`

## Conceito Teórico

Uma **lista** é uma estrutura linear que armazena elementos de forma **dinâmica e ordenada por posição (índice)**. Diferente de um array fixo, o `ArrayList` do Java cresce automaticamente conforme elementos são adicionados.

> Internamente, o `ArrayList` é baseado em um **array dinâmico** que dobra de tamanho quando necessário.

### Quando usar `ArrayList`?

- Quando você precisa de **acesso rápido por índice** (`O(1)`)
- Quando insere/remove principalmente **no final** da lista
- Para **relatórios e exibição ordenada** de dados

### Quando preferir `LinkedList`?

- Quando insere/remove com frequência **no início ou meio** da lista
- Acesso sequencial (não por índice)

---

## Operações Principais

| Operação | Método | Complexidade |
|----------|--------|-------------|
| Inserir no final | `add(elemento)` | O(1) amortizado |
| Inserir em posição | `add(indice, elemento)` | O(n) |
| Remover por valor | `remove(Integer.valueOf(valor))` | O(n) |
| Remover por índice | `remove(indice)` | O(n) |
| Buscar elemento | `contains(elemento)` | O(n) |
| Acessar por índice | `get(indice)` | O(1) |
| Verificar tamanho | `size()` | O(1) |
| Verificar se vazia | `isEmpty()` | O(1) |
| Ordenar | `Collections.sort()` / `.sort(lambda)` | O(n log n) |

---

## 📝 Exemplos de Código em Java

### Criando e manipulando uma lista básica

```java
import java.util.ArrayList;

ArrayList<Integer> lista = new ArrayList<>();

lista.add(15);
lista.add(5);
lista.add(100);
lista.add(45);

System.out.println(lista); // [15, 5, 100, 45]

// ⚠️ Cuidado ao remover inteiros: use Integer.valueOf() para remover por VALOR
// Se usar lista.remove(2), ele remove o ÍNDICE 2, não o valor 2!
lista.remove(Integer.valueOf(100)); // remove o valor 100

System.out.println(lista.contains(100)); // false
```

> **💡 Dica importante:** Ao remover um `Integer` de uma lista, use `Integer.valueOf(valor)` para garantir que está removendo pelo **valor** e não pelo **índice**.

### 🐍 Equivalente em Python

```python
lista = []

lista.append(15)
lista.append(5)
lista.append(100)
lista.append(45)

print(lista)  # [15, 5, 100, 45]

lista.remove(100)  # remove o valor 100 diretamente — sem essa armadilha do Java!

print(100 in lista)  # False
print(len(lista))    # 3
print(lista)         # [15, 5, 45]
```

> 💡 Em Python, `remove()` sempre remove **pelo valor** — não existe o risco de confundir com índice como no Java.

---

## 🔁 Três Formas de Percorrer uma Lista

Em Java, existem três formas de iterar sobre uma lista — cada uma com sua finalidade:

```java
ArrayList<Integer> lista = new ArrayList<>();
lista.add(45);
lista.add(2);
lista.add(42);
lista.add(23);
```

### 1️⃣ Via Índice (for clássico)

Foca no **índice** do elemento. Equivalente ao `lista[i]` do C.

```java
for (int i = 0; i < lista.size(); i++) {
    System.out.println(lista.get(i));
}
```

> ⚠️ **Nunca use para remover elementos** — alterar o tamanho da lista durante o loop causa comportamentos inesperados.

---

### 2️⃣ Via For-Each (objeto)

Foca no **elemento** diretamente. Mais limpo e legível.

```java
for (Integer p : lista) {
    System.out.println(p);
}
```

> ⚠️ **Nunca use para remover elementos** — lança `ConcurrentModificationException`.

---

### 3️⃣ Via Iterator ✅ (modo seguro para remoção)

Foca no **iterador** — um objeto que sabe percorrer a lista e permite remover elementos com segurança durante o percurso.

```java
Iterator<Integer> it = lista.iterator();
while (it.hasNext()) {
    int numero = it.next(); // avança e retorna o elemento atual
    System.out.println(numero);
}
```

**Para remover durante o percurso:**

```java
Iterator<Integer> it = lista.iterator();
while (it.hasNext()) {
    Integer numero = it.next();
    if (numero % 2 == 0) {
        it.remove(); // remoção segura ✅
    }
}
```

> 💡 **Resumo dos percursos:**
>
> | Forma | Usa quando... |
> |-------|--------------|
> | Índice | Precisa do índice do elemento |
> | For-each | Só leitura, código mais limpo |
> | Iterator | Precisa **remover** elementos durante o percurso |

### 🐍 Percursos em Python

Python também oferece formas equivalentes de percorrer listas:

```python
lista = [45, 2, 42, 23]

# 1️⃣ Via índice (equivalente ao for com i em Java)
for i in range(len(lista)):
    print(lista[i])

# 2️⃣ Via for-each (mais comum e limpo em Python)
for elemento in lista:
    print(elemento)

# 3️⃣ Via índice + elemento com enumerate() — o melhor dos dois mundos
for i, elemento in enumerate(lista):
    print(f"índice {i}: {elemento}")

# Remoção segura: em Python, itere sobre uma CÓPIA da lista
for elemento in lista[:]:        # lista[:] cria uma cópia
    if elemento % 2 == 0:
        lista.remove(elemento)   # remove da lista original

print(lista)  # [45, 23]
```

> 💡 Em Python não existe `Iterator` como em Java. A forma segura de remover durante percurso é iterar sobre uma **cópia** com `lista[:]`.

---

## 🔍 Busca com `contains` e o papel do `equals`

O método `contains` verifica se um elemento existe na lista. Em Java, ele usa o método `equals` internamente para comparar os objetos.

```java
lista.contains(100); // retorna true ou false
```

### ⚠️ Atenção com objetos personalizados!

Quando a lista contém **objetos de classes próprias** (não tipos primitivos), o `contains` só funciona corretamente se o método `equals` estiver **sobrescrito** na classe.

Sem `equals`, Java compara **endereços de memória** — dois objetos com os mesmos dados seriam considerados diferentes!

```java
// Classe Processo com equals sobrescrito
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Processo outro = (Processo) obj;
    return this.id == outro.id; // compara pelo ID, não pelo endereço
}
```

### 🐍 Equivalente em Python — método `__eq__`

Em Python, o operador `in` (equivalente ao `contains`) usa o método `__eq__` da classe para comparar. Sem ele, Python compara por identidade de objeto (como o Java sem `equals`).

```python
class Clima:
    def __init__(self, ano, mes, temperatura, precipitacao):
        self.ano = ano
        self.mes = mes
        self.temperatura = temperatura
        self.precipitacao = precipitacao

    # Sem esse método, "clima1 in lista" compara endereços de memória!
    def __eq__(self, outro):
        return self.ano == outro.ano and self.mes == outro.mes

    def __str__(self):
        return f"{self.ano}, {self.mes}, {self.temperatura}, {self.precipitacao}"


lista = []
c1 = Clima(2020, "Janeiro", "Quente", "muita")
c2 = Clima(2020, "Janeiro", "Frio", "pouca")  # mesmo ano e mês

lista.append(c1)

print(c2 in lista)   # True — __eq__ compara ano e mês ✅
print(str(c1))       # 2020, Janeiro, Quente, muita
```

---

## 🔡 Ordenação com `sort` e Lambda

Em vez de usar `Collections.sort()`, podemos usar o método `.sort()` diretamente na lista com uma **expressão lambda**, definindo o critério de ordenação:

```java
// Ordenar lista de Processos pela descrição (ordem alfabética)
lista.sort((p1, p2) -> p1.descricao.compareTo(p2.descricao));
```

Isso é equivalente a criar um `Comparator` manualmente, mas muito mais conciso. O lambda recebe dois elementos e retorna:

- **Negativo** → p1 vem antes de p2
- **Zero** → são iguais
- **Positivo** → p2 vem antes de p1

### 🐍 Equivalente em Python

```python
climas = [
    Clima(2021, "Março", "Frio", "muita"),
    Clima(2020, "Janeiro", "Quente", "pouca"),
    Clima(2019, "Julho", "Ameno", "média"),
]

# Ordenar por mês (alfabético) — equivalente ao lambda do Java
climas.sort(key=lambda c: c.mes)

# Ordenar por ano (numérico)
climas.sort(key=lambda c: c.ano)

# Ordenar por dois critérios: ano crescente, mês alfabético
climas.sort(key=lambda c: (c.ano, c.mes))

for c in climas:
    print(c)
```

> 💡 Em Python, usa-se `key=lambda` (um critério de extração) em vez do `Comparator` do Java que compara dois elementos diretamente.

---

## 🎲 Uso de `Scanner` e `Random` com Listas

Em aula, praticamos o uso de `Scanner` (entrada do usuário) e `Random` (geração de valores aleatórios) combinados com listas de objetos:

```java
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public static void gerarProcessos(ArrayList<Processo> lista) {
    Scanner sc = new Scanner(System.in);
    Random gerador = new Random();

    while (true) {
        int id = gerador.nextInt(500); // ID aleatório entre 0 e 499

        System.out.println("Digite a descrição do processo:");
        String descricao = sc.nextLine().toUpperCase();

        if (descricao.equals("SAIR")) break;

        Processo tmp = new Processo(id, descricao);

        // Só adiciona se não existir (usa o equals da classe Processo)
        if (!lista.contains(tmp)) {
            lista.add(tmp);
        }
    }
}
```

### 🐍 Equivalente em Python — `input()` e `random`

```python
import random

def popular_aleatorio(lista, quantidade, faixa_inicial, faixa_final):
    """Preenche a lista com números aleatórios."""
    for _ in range(quantidade):
        lista.append(random.randint(faixa_inicial, faixa_final))

def gerar_processos(lista):
    """Gera processos com ID aleatório e descrição do usuário, sem duplicatas."""
    while True:
        id_processo = random.randint(0, 499)  # equivalente ao Random.nextInt(500)
        descricao = input("Digite a descrição (SAIR para parar): ").upper()

        if descricao == "SAIR":
            break

        tmp = Processo(id_processo, descricao)

        if tmp not in lista:  # usa __eq__ — equivalente ao contains() do Java
            lista.append(tmp)

def copiar_sem_repeticao(origem, destino):
    """Copia lista sem duplicatas."""
    for item in origem:
        if item not in destino:
            destino.append(item)

# Uso
numeros = []
popular_aleatorio(numeros, quantidade=10, faixa_inicial=1, faixa_final=100)
print(numeros)

processos = []
gerar_processos(processos)
```

---

## 🏷️ Classe `Processo` — Exemplo completo de objeto para lista

```java
public class Processo {
    public int id;
    public String descricao;

    public Processo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Necessário para contains() e remove() por valor funcionarem corretamente
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Processo outro = (Processo) obj;
        return this.id == outro.id;
    }

    // Necessário para System.out.println() exibir algo útil
    @Override
    public String toString() {
        return "Processo{id=" + id + ", descricao='" + descricao + "'}";
    }
}
```

### Operações completas sobre a lista de processos

```java
// Exibir processos ordenados por descrição
public static void exibirProcessos(ArrayList<Processo> lista) {
    System.out.println("Quantidade: " + lista.size());
    lista.sort((p1, p2) -> p1.descricao.compareTo(p2.descricao));
    for (Processo p : lista) {
        System.out.println(p);
    }
}

// Buscar processos que contenham um trecho na descrição
public static void localizarProcessos(ArrayList<Processo> lista) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite parte da descrição:");
    String descricao = sc.nextLine().toUpperCase();

    for (Processo p : lista) {
        if (p.descricao.contains(descricao)) { // busca parcial na String
            System.out.println(p);
        }
    }
}

// Remover processos com Iterator (modo seguro)
public static void removerProcessos(ArrayList<Processo> lista) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite parte da descrição para remover:");
    String descricao = sc.nextLine().toUpperCase();

    Iterator<Processo> it = lista.iterator();
    while (it.hasNext()) {
        Processo p = it.next();
        if (p.descricao.contains(descricao)) {
            it.remove(); // remove com segurança durante o percurso ✅
        }
    }

    System.out.println("Lista após remoção:");
    for (Processo p : lista) {
        System.out.println(p);
    }
}
```

### 🐍 Equivalente em Python — Classe e operações completas

```python
class Processo:
    def __init__(self, id, descricao):
        self.id = id
        self.descricao = descricao

    def __eq__(self, outro):
        return self.id == outro.id  # equivalente ao equals() do Java

    def __str__(self):
        return f"Processo{{id={self.id}, descricao='{self.descricao}'}}"


def exibir_processos(lista):
    print(f"Quantidade de processos: {len(lista)}")
    lista.sort(key=lambda p: p.descricao)  # equivalente ao lambda do Java
    for p in lista:
        print(p)

def localizar_processos(lista):
    descricao = input("Digite parte da descrição: ").upper()
    for p in lista:
        if descricao in p.descricao:  # busca parcial em string
            print(p)

def remover_processos(lista):
    descricao = input("Digite parte da descrição para remover: ").upper()
    # Percorre cópia da lista para remover com segurança
    for p in lista[:]:
        if descricao in p.descricao:
            lista.remove(p)
    print("Lista após remoção:")
    for p in lista:
        print(p)
```

### 📁 Leitura de Arquivo em Python — criando objetos a partir de CSV

```python
# Arquivo clima.csv: 2020,Janeiro,Quente,muita

lista_climas = []

with open("clima.csv", "r") as arquivo:
    for linha in arquivo:
        dados = linha.strip().split(",")  # equivalente ao split() do Java
        # dados = ['2020', 'Janeiro', 'Quente', 'muita']
        clima = Clima(int(dados[0]), dados[1], dados[2], dados[3])
        lista_climas.append(clima)

for c in lista_climas:
    print(c)
```

---

## ✅ Boas Práticas com `ArrayList`

- Sempre sobrescreva `equals` e `toString` em classes que serão armazenadas em listas
- Use `Integer.valueOf()` ao remover inteiros de uma `ArrayList<Integer>` por valor
- **Nunca remova elementos** dentro de um `for` ou `for-each` — use `Iterator`
- Prefira `ArrayList` quando o acesso por índice for frequente; `LinkedList` quando inserções/remoções no início forem frequentes

---

# 2. 🚶 Filas — `Queue`

## Conceito Teórico

A **Fila** segue o princípio **FIFO — First In, First Out**: o **primeiro elemento a entrar é o primeiro a sair**, assim como uma fila de banco ou atendimento.

```text
Entrada → [A] [B] [C] [D] → Saída
           ↑ cauda (inserir)   ↑ cabeça (remover)
```

A fila possui **dois ponteiros**:

- **Cabeça (head/início):** onde ocorre a **remoção**
- **Cauda (tail/fim):** onde ocorre a **inserção**

Em Java, a fila é a interface `Queue`, geralmente implementada com `LinkedList`.

---

## Operações Principais

| Operação | Método (lança exceção) | Método (retorna null/false) | Descrição |
|----------|------------------------|-----------------------------|-----------|
| Inserir no final | `add(e)` | `offer(e)` ✅ | Enfileira um elemento |
| Remover do início | `remove()` | `poll()` ✅ | Desenfileira o primeiro |
| Ver primeiro | `element()` | `peek()` | Visualiza sem remover |
| Verificar se vazia | `isEmpty()` | — | Retorna `true` se vazia |
| Tamanho | `size()` | — | Número de elementos |
| Buscar | `contains(e)` | — | Verifica se existe |

> 💡 **Prefira `offer` e `poll`** — eles não lançam exceção quando a fila está vazia (retornam `false`/`null`), tornando o código mais seguro.

---

## 📝 Exemplos de Código em Java

### Fila básica

```java
import java.util.LinkedList;
import java.util.Queue;

Queue<Integer> fila = new LinkedList<>();

fila.offer(15);  // inserir no final
fila.offer(5);
fila.offer(100);
fila.offer(45);

System.out.println(fila); // [15, 5, 100, 45]

fila.poll();  // remove o primeiro (15)

System.out.println(fila.peek());         // mostra o primeiro sem remover: 5
System.out.println(fila.contains(100));  // true
System.out.println(fila.isEmpty());      // false
```

### 🐍 Equivalente em Python — `collections.deque`

Em Python, a fila é implementada com `collections.deque` (double-ended queue), que é eficiente para inserções e remoções em ambas as extremidades:

```python
from collections import deque

fila = deque()

fila.append(15)    # offer() / add() — inserir no final
fila.append(5)
fila.append(100)
fila.append(45)

print(fila)        # deque([15, 5, 100, 45])

fila.popleft()     # poll() / remove() — remove o primeiro (15)

print(fila[0])     # peek() — ver o primeiro sem remover: 5
print(100 in fila) # contains() — True
print(len(fila))   # size() — 3
print(len(fila) == 0)  # isEmpty() — False
```

> ⚠️ **Por que não usar `list` como fila?**  
> Em Python, usar `lista.pop(0)` para remover o primeiro elemento é O(n) — lento para listas grandes.  
> `deque.popleft()` é O(1) — muito mais eficiente para filas.

| Operação | Java (`Queue`) | Python (`deque`) |
|----------|----------------|------------------|
| Inserir no final | `offer(e)` | `append(e)` |
| Remover do início | `poll()` | `popleft()` |
| Ver o primeiro | `peek()` | `fila[0]` |
| Verificar se vazia | `isEmpty()` | `len(fila) == 0` |

---

## 🏥 Projeto Prático: Sistema de Atendimento com Fila Prioritária

Em aula, implementamos um **sistema de chamada de fichas** com duas filas: uma normal e uma prioritária.

### Regra de negócio

- A cada **3 atendimentos**, um da **fila prioritária** é chamado
- Os demais atendimentos são da **fila normal**
- Fichas normais começam em `1`; fichas prioritárias em `500`

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Chamando {
    public static void main(String[] args) {
        Queue<Integer> filaNormal = new LinkedList<>();
        Queue<Integer> filaPrioritaria = new LinkedList<>();

        int contarNormal = 1;
        int contarPrioritaria = 500;
        int totalAtendidos = 1;

        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        String qualFila = "";

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Ficha Normal");
            System.out.println("2 - Ficha Prioritária");
            System.out.println("3 - Chamar ficha");
            System.out.println("4 - Mostrar fichas");
            System.out.println("5 - Sair");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Ficha Normal: " + contarNormal);
                    filaNormal.offer(contarNormal++);
                    break;

                case "2":
                    System.out.println("Ficha Prioritária: " + contarPrioritaria);
                    filaPrioritaria.offer(contarPrioritaria++);
                    break;

                case "3":
                    int fichaAtendida = -1;

                    // A cada múltiplo de 3, atende da fila prioritária
                    if (totalAtendidos % 3 == 0) {
                        qualFila = "PRIORITÁRIA";
                    } else {
                        qualFila = "NORMAL";
                    }

                    if (qualFila.equals("PRIORITÁRIA") && !filaPrioritaria.isEmpty()) {
                        fichaAtendida = filaPrioritaria.poll();
                    } else if (!filaNormal.isEmpty()) {
                        fichaAtendida = filaNormal.poll();
                    }

                    if (fichaAtendida != -1) {
                        totalAtendidos++;
                        System.out.println("Chamando ficha... " + qualFila + ": " + fichaAtendida);
                    } else {
                        System.out.println("Nenhuma ficha para chamar.");
                    }
                    break;

                case "4":
                    System.out.println("Fila Normal: " + filaNormal);
                    System.out.println("Fila Prioritária: " + filaPrioritaria);
                    break;

                case "5":
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (!opcao.equals("5"));

        scanner.close();
    }
}
```

### Como funciona a lógica de prioridade?

```text
Atendimento 1 → NORMAL        (1 % 3 ≠ 0)
Atendimento 2 → NORMAL        (2 % 3 ≠ 0)
Atendimento 3 → PRIORITÁRIA   (3 % 3 == 0) ✅
Atendimento 4 → NORMAL        (4 % 3 ≠ 0)
Atendimento 5 → NORMAL
Atendimento 6 → PRIORITÁRIA   (6 % 3 == 0) ✅
```

---

## ✅ Boas Práticas com `Queue`

- Prefira `offer()` a `add()` e `poll()` a `remove()` — evitam exceções em filas vazias
- Use duas filas separadas para implementar **sistemas com prioridade**
- Lembre-se: na fila, **você não escolhe quem sai** — sempre sai o primeiro

---

# 3. 📚 Pilhas — `Stack`

## Conceito Teórico

A **Pilha** segue o princípio **LIFO — Last In, First Out**: o **último elemento a entrar é o primeiro a sair**, como uma pilha de pratos.

```text
         ↑ topo (inserir e remover)
        [D]  ← último inserido, primeiro a sair
        [C]
        [B]
        [A]  ← primeiro inserido, último a sair
```

> 💡 Na pilha, **toda a ação acontece no topo** — inserção e remoção são sempre no mesmo lugar.

---

## Operações Principais

| Operação | Método | Descrição |
|----------|--------|-----------|
| Inserir no topo | `push(e)` | Empilha um elemento |
| Remover do topo | `pop()` | Desempilha (não se escolhe quem sai!) |
| Ver o topo | `peek()` | Visualiza sem remover |
| Verificar se vazia | `isEmpty()` | Retorna `true` se vazia |
| Tamanho | `size()` | Número de elementos |
| Buscar | `contains(e)` | Verifica se existe |

> ⚠️ **Na remoção com `pop()`, não se escolhe quem será removido** — a remoção acontece obrigatoriamente no topo.

---

## 📝 Exemplos de Código em Java

```java
import java.util.Stack;

Stack<Integer> pilha = new Stack<>();

pilha.push(15);   // empilha 15
pilha.push(5);    // empilha 5
pilha.push(100);  // empilha 100
pilha.push(45);   // empilha 45

// Estado atual: [15, 5, 100, 45] — topo é 45

pilha.pop();  // remove o topo (45)

// Estado atual: [15, 5, 100]

System.out.println("Topo: " + pilha.peek());     // 100 — visualiza sem remover
System.out.println(pilha.contains(45));          // false — foi removido
System.out.println(pilha.contains(5));           // true
System.out.println(pilha.isEmpty());             // false
System.out.println(pilha.size());                // 3
```

### 🐍 Equivalente em Python — `list` como Pilha

Em Python, uma `list` comum já funciona como pilha, pois `append` insere no topo e `pop()` remove do topo:

```python
pilha = []

pilha.append(15)   # push() — empilha 15
pilha.append(5)    # push() — empilha 5
pilha.append(100)  # push() — empilha 100
pilha.append(45)   # push() — empilha 45

# Estado: [15, 5, 100, 45] — topo é 45 (último da lista)

pilha.pop()        # pop() — remove o topo (45)

# Estado: [15, 5, 100]

print("Topo:", pilha[-1])    # peek() — ver topo sem remover: 100
print(45 in pilha)           # contains() — False
print(5 in pilha)            # True
print(len(pilha) == 0)       # isEmpty() — False
print(len(pilha))            # size() — 3
```

| Operação | Java (`Stack`) | Python (`list`) |
|----------|----------------|-----------------|
| Empilhar | `push(e)` | `append(e)` |
| Desempilhar | `pop()` | `pop()` |
| Ver o topo | `peek()` | `lista[-1]` |
| Verificar se vazia | `isEmpty()` | `len(lista) == 0` |
| Buscar | `contains(e)` | `e in lista` |

---

## Casos de uso reais de Pilha

| Uso | Como a pilha ajuda |
|-----|---------------------|
| **Ctrl+Z (desfazer)** | Cada ação é empilhada; desfazer remove do topo |
| **Histórico do navegador** | Páginas visitadas empilhadas; voltar remove do topo |
| **Chamadas de função** | Call stack: cada chamada empilhada, retorno desempilha |
| **Verificação de parênteses** | Abre `(` → empilha; fecha `)` → desempilha e compara |

---

## ✅ Boas Práticas com `Stack`

- Use pilha quando a ordem de processamento deve ser **inversa à de inserção**
- Sempre verifique `isEmpty()` antes de `pop()` ou `peek()` para evitar `EmptyStackException`
- Em Java moderno, prefira `Deque<T>` com `ArrayDeque` como implementação de pilha (mais eficiente que `Stack`), mas `Stack` é mais didático para aprendizado

---

# 🧬 Hierarquia das Coleções Java e Polimorfismo

## Conceito Teórico

Em Java, as estruturas de dados fazem parte de uma **hierarquia de interfaces e classes** — ou seja, existem "contratos" (interfaces) que definem o que uma estrutura deve ser capaz de fazer, e as classes concretas **herdam e implementam** esses contratos.

Isso vem diretamente do conceito de **herança e polimorfismo** da Orientação a Objetos:

- A **interface/pai** define *o que* pode ser feito (`add`, `remove`, `peek`...)
- A **classe filha/implementação** define *como* isso é feito internamente (`ArrayList`, `LinkedList`, `Stack`...)

---

## A Hierarquia na Prática (corrigida)

```text
java.util.Collection  (interface raiz de todas as coleções)
│
├── List  (interface)
│   ├── ArrayList      → array dinâmico
│   └── LinkedList     → lista duplamente ligada
│
├── Queue  (interface)
│   └── LinkedList     → mesma classe, implementa Queue também!
│
└── Deque  (interface)  → alternativa moderna para pilha/fila
    └── ArrayDeque     → implementação eficiente de pilha/fila

Stack (classe legada) → herda de Vector (não entra na árvore acima)
```

> 💡 **Ponto chave:** `LinkedList` implementa **tanto** `List` **quanto** `Queue`. Por isso ela pode ser usada das duas formas.

---

## Polimorfismo — Declarar com a Interface, Instanciar com a Classe

O grande benefício da hierarquia é poder **declarar a variável pelo tipo da interface** (pai) e **instanciar com a classe concreta** (filha). Isso é polimorfismo em ação:

```java
// ✅ Declarando com a INTERFACE — mais flexível
List<Integer> lista = new ArrayList<>();
List<Integer> lista2 = new LinkedList<>();  // troca só o lado direito!

Queue<Integer> fila = new LinkedList<>();

// ❌ Declarando com a CLASSE — menos flexível
ArrayList<Integer> lista3 = new ArrayList<>(); // preso à implementação
```

A vantagem é que se um dia você precisar **trocar a implementação** (de `ArrayList` para `LinkedList`, por exemplo), basta mudar **uma linha** — o resto do código que usa `lista.add()`, `lista.remove()` etc. continua funcionando igual, porque ambas honram o contrato da interface `List`.

---

## Exemplo Completo — as 3 estruturas com polimorfismo

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// Lista — declarada como List, instanciada como ArrayList
List<Integer> lista = new ArrayList<>();
lista.add(15);
lista.add(5);
lista.add(100);
System.out.println(lista); // [15, 5, 100]

// Troca a implementação sem mudar o restante do código!
List<Integer> listaLigada = new LinkedList<>();
listaLigada.add(15);
listaLigada.add(5);
listaLigada.add(100);
System.out.println(listaLigada); // [15, 5, 100] — mesmo resultado

// Fila — LinkedList implementa Queue
Queue<Integer> fila = new LinkedList<>();
fila.offer(15);
fila.offer(5);
fila.offer(100);
System.out.println(fila.poll()); // 15 — FIFO

// Pilha — Stack clássico (legado, mas didático)
Stack<Integer> pilha = new Stack<>();
pilha.push(15);
pilha.push(5);
pilha.push(100);
System.out.println(pilha.pop()); // 100 — LIFO
```

---

## Por que `LinkedList` consegue ser `List` e `Queue` ao mesmo tempo?

Porque ela **implementa as duas interfaces**. Na prática, a assinatura da classe é:

```java
public class LinkedList<E>
    implements List<E>, Queue<E> { ... }
//             ↑              ↑
//         contrato List   contrato Queue
//         (get, add...)   (offer, poll, peek...)
```

Então dependendo de como você **declara a variável**, você acessa comportamentos diferentes:

```java
// Usando como List — acesso por índice disponível
List<Integer> comoLista = new LinkedList<>();
comoLista.get(0); // ✅ funciona

// Usando como Queue — acesso por índice NÃO disponível
Queue<Integer> comoFila = new LinkedList<>();
// comoFila.get(0); // ❌ erro de compilação — Queue não tem get()!
comoFila.poll(); // ✅ funciona
```

> 💡 **Resumo:** a interface que você escolhe na declaração **determina quais métodos ficam disponíveis** — mesmo que o objeto por baixo seja o mesmo `LinkedList`.

---

## Tabela — Interface × Implementação × Uso

| Interface (pai) | Implementação (filha) | Característica principal | Use quando... |
|-----------------|------------------------|--------------------------|---------------|
| `List` | `ArrayList` | Array dinâmico | Acesso por índice frequente |
| `List` | `LinkedList` | Lista duplamente ligada | Inserções/remoções no início |
| `Queue` | `LinkedList` | FIFO com dois ponteiros | Precisa de fila |
| — | `Stack` | LIFO clássico (legado) | Precisa de pilha (didático) |
| `Deque` | `ArrayDeque` | LIFO/FIFO eficiente | Pilha/fila em código de produção |

---

# ⚖️ Comparativo: `ArrayList` vs `LinkedList`

| Critério | `ArrayList` | `LinkedList` |
|----------|-------------|--------------|
| Estrutura interna | Array dinâmico | Lista duplamente ligada |
| Acesso por índice | Rápido — O(1) | Lento — O(n) |
| Inserção/remoção no **final** | Rápido — O(1) | Rápido — O(1) |
| Inserção/remoção no **início/meio** | Lento — O(n) | Rápido — O(1) |
| Consumo de memória | Menor | Maior (armazena ponteiros) |
| Quando usar | Acesso frequente por índice | Inserções/remoções frequentes |

---

# 4. 🔢 Matrizes Especiais

## Conceito Teórico

**Matrizes Especiais** são matrizes com **muitas linhas e muitas colunas** (grande dimensão) nas quais a **maioria das células é igual a zero ou nula**. Ocorrem com frequência em:

- 🖼️ Tratamento de imagens e vídeos (pixels com valor 0 = fundo preto)
- 📊 Planilhas eletrônicas esparsas
- 🔬 Simulações físicas e científicas

---

## ⚠️ Principais Problemas

| Problema | Causa |
|----------|-------|
| **Consumo excessivo de memória** | Armazenar zeros que não carregam informação |
| **Tempo de processamento excessivo** | Iterar sobre milhões de células inúteis |

Exemplo: uma imagem em tons de cinza de 1920×1080 tem **2.073.600 células**. Se 95% delas forem zero (fundo preto), ainda assim toda aquela memória seria alocada.

---

## ✅ Solução — Lista Encadeada de Pixels Não Nulos

Em vez de guardar toda a matriz, **descarta-se a matriz e converte-se apenas os elementos não nulos em nós de uma lista encadeada**. Cada nó armazena:

| Campo | Descrição |
|-------|-----------|
| `linha` | Índice da linha na matriz original |
| `coluna` | Índice da coluna na matriz original |
| `valor` | O pixel (em tons de cinza: 0–255) |
| `prox` | Referência para o próximo nó |

### Escala de cores

- **Tons de cinza:** pixel de `0` (preto) a `255` (branco)
- **RGB:** três componentes, cada um de `0` a `255`
  - `r` → vermelho, `g` → verde, `b` → azul

### Representação de um nó (pixel RGB não nulo)

```text
┌────────┬────────┬─────┬─────┬─────┬──────┐
│ linha  │ coluna │  r  │  g  │  b  │ prox │
│   0    │   1    │ 200 │ 123 │ 233 │  →   │
└────────┴────────┴─────┴─────┴─────┴──────┘
```

---

## 🗂️ Tipos de Matrizes Especiais

### 1. Esparsa

A maioria das células é zero. Não há condição geométrica fixa — os elementos não nulos aparecem em posições espalhadas.

**Aplicações:** imagens, vídeos, planilhas eletrônicas, grafos de redes sociais.

```text
0  0  7  0
0  0  0  3
0  5  0  0
0  0  0  2
```

### 2. Diagonal Principal

Somente os elementos onde `i == j` são não nulos (a diagonal do canto superior esquerdo ao inferior direito).

```text
5  0  0  0
0  8  0  0
0  0  3  0
0  0  0  1
```

### 3. Diagonal Secundária

Somente os elementos onde `i + j == n - 1` são não nulos (diagonal do canto superior direito ao inferior esquerdo).

```text
0  0  0  4
0  0  7  0
0  2  0  0
9  0  0  0
```

### 4. Triangular Superior da Principal

Elementos não nulos onde `j > i` (acima da diagonal principal, sem incluí-la).

```text
0  3  6  1
0  0  4  8
0  0  0  2
0  0  0  0
```

### 5. Triangular Inferior da Principal

Elementos não nulos onde `i > j` (abaixo da diagonal principal, sem incluí-la).

```text
0  0  0  0
7  0  0  0
3  5  0  0
2  9  4  0
```

### 6. Triangular Superior da Secundária

Elementos não nulos onde `i + j < n - 1` (acima da diagonal secundária, sem incluí-la).

```text
1  4  7  0
2  6  0  0
8  0  0  0
0  0  0  0
```

### 7. Triangular Inferior da Secundária

Elementos não nulos onde `i + j > n - 1` (abaixo da diagonal secundária, sem incluí-la).

```text
0  0  0  0
0  0  0  3
0  0  5  9
0  2  7  4
```

---

## 📝 Exemplos de Código em Java

### Classe `Pixel` — nó da lista encadeada (tons de cinza)

```java
public class Pixel {
    public int linha;
    public int coluna;
    public int valor;   // 0 a 255 para tons de cinza

    public Pixel(int linha, int coluna, int valor) {
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pixel{l=" + linha + ", c=" + coluna + ", v=" + valor + "}";
    }
}
```

### Convertendo uma matriz esparsa para lista encadeada

```java
import java.util.ArrayList;

public static ArrayList<Pixel> converterEsparsa(int[][] matriz) {
    ArrayList<Pixel> lista = new ArrayList<>();
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] != 0) {              // ignora zeros
                lista.add(new Pixel(i, j, matriz[i][j]));
            }
        }
    }
    return lista;
}
```

### Detectando cada tipo especial

```java
public static void classificarMatriz(int[][] m) {
    int n = m.length;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (m[i][j] == 0) continue;

            // Diagonal principal
            if (i == j)
                System.out.println("Diagonal principal: (" + i + "," + j + ")");

            // Diagonal secundária
            if (i + j == n - 1)
                System.out.println("Diagonal secundária: (" + i + "," + j + ")");

            // Triangular superior da principal
            if (j > i)
                System.out.println("Tri. sup. principal: (" + i + "," + j + ")");

            // Triangular inferior da principal
            if (i > j)
                System.out.println("Tri. inf. principal: (" + i + "," + j + ")");

            // Triangular superior da secundária
            if (i + j < n - 1)
                System.out.println("Tri. sup. secundária: (" + i + "," + j + ")");

            // Triangular inferior da secundária
            if (i + j > n - 1)
                System.out.println("Tri. inf. secundária: (" + i + "," + j + ")");
        }
    }
}
```

### Classe `PixelRGB` — nó com cor completa

```java
public class PixelRGB {
    public int linha, coluna;
    public int r, g, b;   // 0 a 255 cada canal

    public PixelRGB(int linha, int coluna, int r, int g, int b) {
        this.linha = linha;
        this.coluna = coluna;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    // Pixel é considerado "nulo" se todos os canais forem zero (preto puro)
    public boolean ehNulo() {
        return r == 0 && g == 0 && b == 0;
    }

    @Override
    public String toString() {
        return "Pixel{l=" + linha + ", c=" + coluna
             + ", rgb=(" + r + "," + g + "," + b + ")}";
    }
}
```

### Convertendo imagem RGB para lista — descartando pixels pretos

```java
import java.util.ArrayList;

public static ArrayList<PixelRGB> converterRGB(int[][][] imagem) {
    ArrayList<PixelRGB> lista = new ArrayList<>();
    int linhas = imagem.length;
    int colunas = imagem[0].length;

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            int r = imagem[i][j][0];
            int g = imagem[i][j][1];
            int b = imagem[i][j][2];

            // Guarda apenas pixels não nulos (não preto puro)
            if (r != 0 || g != 0 || b != 0) {
                lista.add(new PixelRGB(i, j, r, g, b));
            }
        }
    }
    return lista;
}
```

### Exemplo completo — uso real

```java
import java.util.ArrayList;

public static void main(String[] args) {
    // Matriz 4x4 esparsa em tons de cinza
    int[][] imagem = {
        {0,   0, 128,   0},
        {0,   0,   0, 255},
        {0,  64,   0,   0},
        {0,   0,   0, 200}
    };

    ArrayList<Pixel> lista = converterEsparsa(imagem);

    System.out.println("Matriz 4x4 → " + (4 * 4) + " células alocadas");
    System.out.println("Lista encadeada → apenas " + lista.size() + " nós");
    System.out.printf("Economia de memória: %.0f%%\n",
        (1 - (double) lista.size() / 16) * 100);

    for (Pixel p : lista) {
        System.out.println(p);
    }
}
// Saída:
// Matriz 4x4 → 16 células alocadas
// Lista encadeada → apenas 4 nós
// Economia de memória: 75%
// Pixel{l=0, c=2, v=128}
// Pixel{l=1, c=3, v=255}
// Pixel{l=2, c=1, v=64}
// Pixel{l=3, c=3, v=200}
```

---

## 🐍 Equivalente em Python

```python
class Pixel:
    def __init__(self, linha, coluna, valor):
        self.linha = linha
        self.coluna = coluna
        self.valor = valor          # 0–255 para tons de cinza

    def __str__(self):
        return f"Pixel{{l={self.linha}, c={self.coluna}, v={self.valor}}}"


class PixelRGB:
    def __init__(self, linha, coluna, r, g, b):
        self.linha = linha
        self.coluna = coluna
        self.r = r
        self.g = g
        self.b = b

    def eh_nulo(self):
        return self.r == 0 and self.g == 0 and self.b == 0

    def __str__(self):
        return f"Pixel{{l={self.linha}, c={self.coluna}, rgb=({self.r},{self.g},{self.b})}}"


def converter_esparsa(matriz):
    """Converte matriz esparsa em lista com apenas elementos não nulos."""
    lista = []
    for i, linha in enumerate(matriz):
        for j, valor in enumerate(linha):
            if valor != 0:
                lista.append(Pixel(i, j, valor))
    return lista


def converter_rgb(imagem):
    """Converte imagem RGB (lista 3D) em lista de PixelRGB não nulos."""
    lista = []
    for i, linha in enumerate(imagem):
        for j, pixel in enumerate(linha):
            r, g, b = pixel
            if r != 0 or g != 0 or b != 0:
                lista.append(PixelRGB(i, j, r, g, b))
    return lista


def classificar_celula(i, j, n):
    """Retorna os tipos especiais de uma célula (i, j) em matriz n x n."""
    tipos = []
    if i == j:              tipos.append("diagonal principal")
    if i + j == n - 1:     tipos.append("diagonal secundária")
    if j > i:               tipos.append("tri. sup. principal")
    if i > j:               tipos.append("tri. inf. principal")
    if i + j < n - 1:      tipos.append("tri. sup. secundária")
    if i + j > n - 1:      tipos.append("tri. inf. secundária")
    return tipos


# ── Exemplo: esparsa em tons de cinza ──────────────────────────────
imagem = [
    [  0,   0, 128,   0],
    [  0,   0,   0, 255],
    [  0,  64,   0,   0],
    [  0,   0,   0, 200],
]

lista = converter_esparsa(imagem)

print(f"Matriz 4×4 → {4 * 4} células alocadas")
print(f"Lista encadeada → apenas {len(lista)} nós")
print(f"Economia de memória: {(1 - len(lista) / 16) * 100:.0f}%")

for p in lista:
    print(p)

# Saída:
# Matriz 4×4 → 16 células alocadas
# Lista encadeada → apenas 4 nós
# Economia de memória: 75%
# Pixel{l=0, c=2, v=128}
# Pixel{l=1, c=3, v=255}
# Pixel{l=2, c=1, v=64}
# Pixel{l=3, c=3, v=200}

# ── Exemplo: identificar tipos por célula ──────────────────────────
n = 4
for i in range(n):
    for j in range(n):
        tipos = classificar_celula(i, j, n)
        if tipos:
            print(f"({i},{j}) → {', '.join(tipos)}")
```

---

## 📊 Tabela de Condições — Resumo

| Tipo | Condição | Exemplo de uso |
|------|----------|----------------|
| **Esparsa** | maioria das células == 0 | Imagens, planilhas, grafos |
| **Diagonal principal** | `i == j` | Matrizes identidade |
| **Diagonal secundária** | `i + j == n - 1` | Rotações, espelhamentos |
| **Tri. sup. principal** | `j > i` | Sistemas lineares, Cholesky |
| **Tri. inf. principal** | `i > j` | Eliminação de Gauss |
| **Tri. sup. secundária** | `i + j < n - 1` | Variações de triangularização |
| **Tri. inf. secundária** | `i + j > n - 1` | Variações de triangularização |

---

## ✅ Boas Práticas com Matrizes Especiais

- **Nunca aloque a matriz completa** se ela for esparsa — use lista encadeada ou `HashMap` com a chave `(linha, coluna)`
- Ao criar a lista, **percorra a matriz uma única vez** — O(n²) — e adicione somente os não nulos
- Sempre guarde `linha` e `coluna` no nó, pois a posição original é informação essencial
- Para imagens reais, considere formatos comprimidos (PNG, JPEG) que já aplicam esse princípio internamente
- Em Python, `scipy.sparse` e `numpy` oferecem estruturas prontas para matrizes esparsas de alta performance

---

# 🌐 Estruturas Não Lineares (Visão Geral)

Além das estruturas lineares, existem estruturas mais complexas estudadas conceitualmente:

### Matrizes

Estruturas com duas ou mais dimensões:

```text
[1 2 3]
[4 5 6]
[7 8 9]
```

### Árvores

Estruturas hierárquicas com nós conectados:

```text
      A
     / \
    B   C
   /
  D
```

Operações: inserção, remoção, busca.

### Grafos

Vértices conectados por arestas. Muito usados em: redes sociais, mapas, sistemas de rotas e redes de computadores.

---

# 🚀 Evolução Prática

Aqui está um registro da evolução do aprendizado ao longo das aulas — do conceito à implementação real:

| Etapa | O que foi aprendido |
|-------|----------------------|
| 📖 **Teoria inicial** | Diferença entre estruturas físicas e abstratas; conceito de listas, pilhas e filas |
| 🐍 **Python** | Manipulação de listas com `append`, `remove`, `in`; geração de números aleatórios com `random`; leitura de arquivos e criação de objetos |
| ☕ **Java — ArrayList** | Criação de listas tipadas, `add`, `remove`, `contains`, `size` |
| 🔁 **Percursos** | Três formas de iterar: índice, for-each e **Iterator** — e quando usar cada uma |
| 🗑️ **Remoção segura** | Uso de `Iterator` com `it.remove()` para evitar `ConcurrentModificationException` |
| 🔍 **Busca com `contains`** | Entendimento de que `contains` depende do `equals` — necessidade de sobrescrever o método em classes personalizadas |
| 🔡 **Ordenação com lambda** | `lista.sort((p1, p2) -> p1.descricao.compareTo(p2.descricao))` — ordenação funcional e concisa |
| 🎲 **Scanner + Random** | Entrada interativa do usuário + geração de IDs aleatórios; validação de duplicatas com `contains` |
| 📁 **Leitura de arquivos** | `BufferedReader`, `readLine()`, `split()` — transformação de linhas CSV em objetos |
| 🚶 **Queue (Fila)** | Conceito FIFO, `offer`, `poll`, `peek`; diferença entre métodos que lançam exceção e os que retornam null |
| 🏥 **Fila com prioridade** | Implementação de sistema de atendimento com duas filas e lógica de alternância por módulo (`%`) |
| 📚 **Stack (Pilha)** | Conceito LIFO, `push`, `pop`, `peek`; entendimento de que a remoção sempre ocorre no topo |

---

## 📎 Estrutura de Arquivos do Repositório

```text
📁 estrutura-de-dados/
├── 📄 Processo.java          # Classe modelo com equals e toString
├── 📄 Estruturas.java        # Operações com ArrayList de objetos
├── 📄 ListaPercorrer.java    # Três formas de percurso em listas
├── 📄 Colecoes.java          # Exemplos de ArrayList, Stack e Queue
└── 📄 Chamando.java          # Sistema de filas com prioridade
```

---

> **"Entender estruturas de dados é entender como o computador pensa."**  
> Siga estudando e documentando!