
# Repositório destinado às aulas de Estrutura de Dados
## Professor Alexandre Zamberlan - alexz@ufn.edu.br - github.com/alexandrezamberlan

# 📚 Resumo — Estruturas de Dados (Conteúdo Estudado até Agora)

## Introdução

Estruturas de Dados é uma área da **Ciência da Computação** que estuda formas de **organizar, armazenar e manipular dados na memória do computador** de maneira eficiente.

O objetivo é desenvolver **algoritmos capazes de gerenciar dados da melhor forma possível**, permitindo operações rápidas de:

- inserção de dados  
- remoção de dados  
- busca de informações  
- organização de dados  

Esses conceitos são fundamentais para a construção de **programas eficientes e bem estruturados**.

---

# Estruturas de Dados Físicas e Abstratas

## Estruturas de Dados Físicas

São estruturas **dependentes da linguagem de programação**, representando diretamente como os dados são armazenados na memória.

**Exemplos:**

- `int`
- `float`
- `char`
- `string`
- vetores
- matrizes

Cada linguagem implementa esses tipos de forma diferente. Por exemplo, o tipo `int` em **Java** pode ter comportamento diferente do `int` em **C**.

---

## Estruturas de Dados Abstratas (EDA)

São estruturas **conceituais**, independentes da linguagem utilizada.

Representam **modelos de organização de dados e algoritmos para manipulação da memória**.

**Principais exemplos:**

- Lista
- Pilha
- Fila
- Árvore
- Grafo

Cada linguagem possui suas próprias implementações dessas estruturas.

**Exemplo:**  
| Linguagem | Implementação de Lista           |
|-----------|----------------------------------|
| C++       | vector                           |
| Java      | List, ArrayList, LinkedList      |
| C#        | List                             |
| Python    | list                             |

---

# Estruturas Lineares

São estruturas onde os dados são organizados **em sequência**.

## Vetores

Também chamados de **arrays**, armazenam elementos em posições consecutivas da memória.

Exemplo:

```
[5, 9, 7, 2, 5]
```

Cada elemento possui um **índice** que indica sua posição.

---

## Listas

Lista é uma estrutura que permite **armazenar vários elementos dinamicamente**.

**Principais operações:**
- inserir elementos
- remover elementos
- verificar tamanho
- verificar se está vazia
- localizar elementos

### Exemplos de inserção

**Python:**
```python
lista.append(valor)
```

**Java:**
```java
lista.add(valor);
```

**C++:**
```cpp
lista.push_back(valor);
```

---

## Outras Estruturas Lineares

### Pilha (Stack)

Segue o princípio **LIFO (Last In, First Out)**.

O último elemento inserido é o primeiro a sair.

**Operações comuns:**
- `push` (inserir)
- `pop` (remover)
- topo
- verificar se está vazia

**Exemplo conceitual:**
```
Topo
 ↓
[10]
[5]
[2]
```

### Fila (Queue)

Segue o princípio **FIFO (First In, First Out)**.

O primeiro elemento inserido é o primeiro a sair.

**Operações principais:**
- inserir
- remover
- acessar primeiro elemento
- acessar último elemento

**Exemplo:**
```
Entrada → [5][9][2] → Saída
```

---

# Estruturas Não Lineares

## Matrizes

São estruturas com duas ou mais dimensões.

**Exemplo:**
```
[1 2 3]
[4 5 6]
[7 8 9]
```

---

## Árvores

Estruturas hierárquicas formadas por nós conectados.

**Exemplo:**
```
      A
     / \
    B   C
   /
  D
```

**Operações comuns:**
- inserção
- remoção
- busca

---

## Grafos

Estruturas formadas por **vértices** (nós) e **arestas** (ligações).

**São utilizadas em:**
- redes sociais
- mapas
- sistemas de rotas
- redes de computadores

---

# Operações Básicas em Estruturas de Dados

## Inserção

| Linguagem | Método         |
|-----------|----------------|
| C++       | push_back()    |
| Java      | add()          |
| Python    | append()       |

## Remoção

| Linguagem | Método             |
|-----------|--------------------|
| C++       | erase(), pop_back()|
| Java      | remove()           |
| Python    | remove()           |

## Verificar tamanho

| Linguagem | Método   |
|-----------|----------|
| C++       | size()   |
| Java      | size()   |
| Python    | len()    |

## Verificar se está vazia

Pode ser feito verificando:  
`tamanho == 0`  

Ou utilizando métodos específicos como:  
`isEmpty()`  
`empty()`

## Busca de Elementos

Buscar um elemento significa verificar se ele existe na estrutura.

**Exemplo em C:**
```c
for(int i =0; i<5; i++){
  if(numero == vetor[i]){
      encontrado = true;
      break;
  }
}
```

**Python:**
```python
if numero in vetor:
    print("Encontrado")
```

**Java:**
```java
if(vetor.contains(numero)){
    System.out.println("Encontrado");
}
```

---

# Manipulação de Listas em Python

- **Criar lista**  
  `lista = []`
- **Adicionar elementos**  
  `lista.append(valor)`
- **Remover elemento**  
  `lista.remove(valor)`
- **Verificar se existe**  
  `if valor in lista:`
- **Verificar tamanho**  
  `len(lista)`

---

# Exercícios com Listas e Números Aleatórios

Foram criadas funções para manipular listas:

**Gerar números aleatórios**
```python
import random

def popular_aleatorio(lista, quantidade, faixa_inicial, faixa_final):
    for i in range(quantidade):
        lista.append(random.randint(faixa_inicial, faixa_final))
```

**Exibir lista**
```python
def exibir_lista(lista):
    for item in lista:
        print(item)
    print("Total:", len(lista))
```

**Copiar lista sem repetição**
```python
def copiar_lista(lista_origem, lista_destino):
    for item in lista_origem:
        if item not in lista_destino:
            lista_destino.append(item)
```
Esse método cria uma nova lista sem valores duplicados.

---

# Leitura de Arquivos e Objetos

Também foi estudado como ler arquivos e transformar os dados em objetos.

**Processo:**
- Ler arquivo
- Ler linha por linha
- Separar os dados com split
- Criar um objeto
- Inserir em uma lista

**Exemplo de linha do arquivo:**
```
2020,Janeiro,Quente,muita
```
**Após o split:**
```
[2020, Janeiro, Quente, muita]
```

---

## Classe Clima

A classe Clima representa informações climáticas.

**Atributos:**
- ano
- mês
- temperatura
- precipitação

### Python:
```python
class Clima:
    def __init__(self, ano, mes, temperatura, precipitacao):
        self.ano = ano
        self.mes = mes
        self.temperatura = temperatura
        self.precipitacao = precipitacao
```

### Métodos Importantes

- `__str__` / `toString()`: Usado para exibir o objeto de forma legível.
- `__eq__` / `equals()`: Define quando dois objetos são considerados iguais.

No exemplo da classe Clima:

> Dois objetos são iguais se possuem o mesmo ano e mês.  
> Isso evita inserir dados duplicados na lista.

---

## Leitura de Arquivos em Java

Java pode ler arquivos utilizando `BufferedReader`.

Exemplo:
```java
BufferedReader leitor = new BufferedReader(
    new FileReader(nomeBase)
);
```
Depois as linhas são separadas com:
```java
linha.split(",");
```

---

# Conclusão

Até o momento na disciplina de Estruturas de Dados foram estudados os seguintes conceitos principais:

- organização de dados na memória
- estruturas físicas e abstratas
- estruturas lineares e não lineares
- listas, pilhas, filas, árvores e grafos
- operações básicas (inserção, remoção e busca)
- manipulação de listas em Python
- geração de números aleatórios
- remoção de elementos duplicados
- leitura de arquivos
- criação de classes e objetos
- comparação de objetos para evitar duplicação
