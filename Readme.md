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

São dependentes da linguagem de programação, representando diretamente como os dados são armazenados na memória. Exemplos:

- `int`
- `float`
- `char`
- `string`
- vetores (arrays)
- matrizes

Cada linguagem implementa esses tipos de forma diferente. Por exemplo: `int` em Java pode ter tamanho ou comportamento diferente do `int` em C.

## Estruturas de Dados Abstratas (EDA)

São estruturas conceituais, independentes da linguagem utilizada. Representam modelos de organização de dados e algoritmos para manipulação da memória. Exemplos:

- Lista
- Pilha (Stack)
- Fila (Queue)
- Árvore (Tree)
- Grafo (Graph)

Cada linguagem possui suas implementações dessas estruturas.

**Exemplo de Listas em diferentes linguagens:**

| Linguagem | Implementação de Lista           |
|-----------|----------------------------------|
| C++       | vector                           |
| Java      | List, ArrayList, LinkedList      |
| C#        | List                             |
| Python    | list                             |

---

# Estruturas Lineares

São as estruturas onde os dados são organizados **em sequência**.

## Vetores (Arrays)

Vetores armazenam elementos em posições consecutivas da memória e cada elemento possui um índice (posição).

Exemplo:  
[5, 9, 7, 2, 5]

## Listas

Permitem armazenar vários elementos dinamicamente.

**Principais operações:**
- inserir elementos
- remover elementos
- verificar tamanho
- verificar se está vazia
- localizar elementos

### Exemplos de inserção

**Python:**  `lista.append(valor)`  
**Java:**  `lista.add(valor);`  
**C++:**  `lista.push_back(valor);`

---

# Outras Estruturas Lineares

## Pilha (Stack)

Princípio **LIFO (Last In, First Out)**: O último elemento inserido é o primeiro a sair.

Operações comuns:
- `push` (inserir)
- `pop` (remover)
- topo (ver elemento do topo)
- verificar se está vazia

## Fila (Queue)

Princípio **FIFO (First In, First Out)**: O primeiro elemento inserido é o primeiro a sair.

Operações principais:
- inserir
- remover
- acessar primeiro/último elemento

---

# Estruturas Não Lineares

## Matrizes

Estruturas com duas ou mais dimensões.  
Exemplo:
```
[1 2 3]
[4 5 6]
[7 8 9]
```

## Árvores

Estruturas hierárquicas formadas por nós conectados.  
Exemplo:
```
      A
     / \
    B   C
   /
  D
```
Operações comuns: inserção, remoção, busca.

## Grafos

Estruturas formadas por vértices (nós) e arestas (ligações). Usados em redes sociais, mapas, sistemas de rotas, redes de computadores.

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

- `tamanho == 0`  
- Métodos: `isEmpty()`, `empty()`

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

# Métodos equals e contains (e comparação de objetos)

## equals

O método `equals` (Java) serve para comparar se dois objetos são equivalentes do ponto de vista de suas informações, não apenas se estão no mesmo endereço da memória.

**Exemplo Java:**
```java
public boolean equals(Object obj) {
    if (this == obj) return true; // mesmo endereço de memória
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    Clima outro = (Clima) obj;
    return this.ano == outro.ano && this.mes.equals(outro.mes);
}
```

No Python, usa-se o método `__eq__`:
```python
def __eq__(self, outro):
    return self.ano == outro.ano and self.mes == outro.mes
```

## contains

`contains` serve para consultar se um valor existe em uma lista/estrutura. Em Java, `contains` usa o método `equals` dos objetos para comparar.

**Importante:**  
Se o método `equals` NÃO estiver corretamente implementado na sua classe, o `contains` pode falhar (exemplo: dois objetos com os mesmos valores podem ser considerados diferentes se a comparação usar o endereço de memória — o padrão dos objetos do Java sem sobrescrita de `equals`).

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

Processo:
- Ler arquivo
- Ler linha por linha (`for`/`while`)
- Separar os dados com `split`
- Criar um objeto
- Inserir em uma lista

**Exemplo de linha do arquivo:**  
`2020,Janeiro,Quente,muita`  
Após split:  
`[2020, Janeiro, Quente, muita]`

---

## Classe Clima

Representa informações climáticas.

**Atributos:** ano, mês, temperatura, precipitação

**Exemplo Python:**
```python
class Clima:
    def __init__(self, ano, mes, temperatura, precipitacao):
        self.ano = ano
        self.mes = mes
        self.temperatura = temperatura
        self.precipitacao = precipitacao
    def __eq__(self, outro):
        return self.ano == outro.ano and self.mes == outro.mes
    def __str__(self):
        return f'{self.ano}, {self.mes}, {self.temperatura}, {self.precipitacao}'
```

---

## Leitura de Arquivos em Java

Java pode ler arquivos utilizando `BufferedReader`:

```java
BufferedReader leitor = new BufferedReader(
    new FileReader(nomeBase)
);
String linha = leitor.readLine();
String[] dados = linha.split(",");
```

---

# Comparativo: Vector, List, ArrayList e LinkedList

### **vector (C++):**
- Estrutura dinâmica de array; redimensiona automaticamente.
- Crescimento e acesso rápido (O(1) para acesso por índice).
- Bem eficiente para acesso aleatório.
- Inserções/remover no fim são rápidas; no meio/início são lentas.

### **list (C++):**
- Tipicamente, implementada como **lista duplamente ligada**.
- Inserção e remoção rápidas em qualquer ponto (O(1)), mas **acesso aleatório é lento** (O(n)).
- Usa muito ponteiro: consome mais memória para grandes listas.

### **ArrayList (Java):**
- Estrutura baseada em array dinâmico.
- Acesso aleatório rápido (O(1)).
- Inserção/remoção eficiente apenas no final.
- Crescimento automático: normalmente dobra quando cheio.

### **LinkedList (Java):**
- Lista duplamente ligada.
- Inserção/remoção rápidas em qualquer lugar.
- Acesso sequencial, não eficiente para acesso aleatório (O(n)).
- Permite inserir/remover no início/fim rapidamente.

#### **Resumo (+ Quando usar uma ou outra):**

| Estrutura     | Quando usar                                                           |
|---------------|----------------------------------------------------------------------|
| **vector**    | Precisa de acesso rápido por índice e poucas inserções no meio (C++)  |
| **list**      | Precisa inserir/remover dados com frequência no início/meio (C++)     |
| **ArrayList** | Precisa de acessos aleatórios rápidos e inserir/remover só no fim     |
| **LinkedList**| Precisa inserir/remover com frequência em qualquer posição            |

- Para buscas por índice rápidas e poucas inserções/remoções: **vector ou ArrayList**
- Para inserção/remoção frequente fora do final: **list ou LinkedList**
- Para manipulação sequencial: qualquer um pode servir, escolha pensando em performance.

---

# Resumo Visual: Diferenças

| Estrutura      | Implementação         | Acesso Aleatório | Inserção/Remoção Início  | Inserção/Remoção Meio   | Inserção/Remoção Final | Memória    |
| -------------- | -------------------- | ---------------:| -----------------------: | ----------------------:| ---------------------:| ----------:|
| vector (C++)   | Array dinâmico        |      Rápido     |         Lento            |         Lento           |        Rápido         | Econômica  |
| list (C++)     | Lista duplamente ligada|      Lento      |         Rápido           |        Rápido           |        Rápido         | Mais alta  |
| ArrayList      | Array dinâmico        |      Rápido     |         Lento            |         Lento           |        Rápido         | Econômica  |
| LinkedList     | Lista duplamente ligada|     Lento      |         Rápido           |        Rápido           |        Rápido         | Mais alta  |

---

# Conclusão

Até o momento, foram estudados:

- Organização de dados na memória
- Estruturas físicas e abstratas
- Estruturas lineares e não lineares: listas, pilhas, filas, árvores e grafos
- Operações básicas: inserção, remoção e busca, métodos equals e contains, comparação de objetos
- Exercícios de manipulação de listas em Python
- Geração de números aleatórios e remoção de duplicados
- Leitura de arquivos e transformação de linhas em objetos
- Diferenças, vantagens e indicações de uso de vector, list, ArrayList e LinkedList

**Siga estudando e documentando! 👨‍💻**