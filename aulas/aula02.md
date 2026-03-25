# O que é Estrutura de Dados?
- Disciplina ou área da Ciência da COmputação que estuda algoritmos para melhor gestão de meória
- Estrututas de Dados Físicas
  - Variáveis: dependetes das linguagens de programação
    - int do java é diferente do int do C
- Estruturas de Dados Abstratas
  - algoritmos de gestão de memórias
  - estruturas lineares: vetores - matriz de 1 dimensão
    - pilhas (Stack): inserção, remoção, estaVazia, tamanho, localizar, topo...
    - fila (Queue): inserção, remoção, estaVazia, localizar, primeiro, último...
    - lista (List): inserção, remoção, estaVazia, localizar
- estruturas não lineares: matrizes de N dimensões
    - árvore (tree): inserção, remoção, estaVazia, localizar
    - grafo: remoção, caminho, melhorCaminho
## Exemplo em Python do funcionamento de Lista
```
lista_nomes = []

#adicioanr nomes na lista
lista_nomes.append("Guilherme")
lista_nomes.append("Bruno")
lista_nomes.append("Leonardo")

#exibir a lista inteira 
print(lista_nomes)

#remover um nome da lista
if len(lista_nomes) != 0:
    nome = input("Digite um nome: ")
    if lista_nomes.__contains__(nome):
        lista_nomes.remove(nome)
    else:
        print(nome, "não esta na lista")

    print(lista_nomes)
else: 
    print("Lista vazia...")

```

## Exemplo em Java do funcionamento de Lista

```
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ExemploLista1 {

    public static void main(String[]args){
        ArrayList<String> listaNomes = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        String nome;

        listaNomes.add("Guilherme");
        listaNomes.add("Pedro");
        listaNomes.add("Maria");

        System.out.println(listaNomes);

        if(listaNomes.size() != 0){
            System.out.println("Digite um nome: ");
            nome = teclado.nextLine();
            if(listaNomes.contains(nome)){
                listaNomes.remove(nome);
            }else{
                System.out.println("Nome não localizado");
            }

            System.out.println("Total de elementos: " + listaNomes.size());
            System.out.println(listaNomes);
        }
    }
}

```
## Exemplo em C++ do funcionamento de Lista - Main
```
#include <cstdlib>
#include <iostream>
#include <string>
#define TAMANHO 10

using namespace std;

#include "utilidades.h"


int main(){
    string vetorNomes[TAMANHO]; 
    inicializar(vetorNomes);
    int totalNomesInseridos = 0;

    totalNomesInseridos = inserir ("Davi", vetorNomes, totalNomesInseridos);
    totalNomesInseridos = inserir ("Eduardo", vetorNomes, totalNomesInseridos);
    totalNomesInseridos = inserir ("Gabriel", vetorNomes, totalNomesInseridos);

    if(totalNomesInseridos>0){
        exibir(vetorNomes);
    } else{
        cout << "Vetor de nomes vazio\n";
    }
   

    //todo vetor é um ponteiro 

    //CMD: cd downloads > cd Estrutura_de_Dados > dir > g++ .\exemploLista1.cpp -o roda > .\roda.exe


    return 1;
}
```
## Biblioteca utilidades.h do C++
```
#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;

void inicializar(string vetor[]){
    for(int i =0; i< TAMANHO; i++){
        vetor[i] = "branco";
    }
}


int inserir(string nome, string vetor[], int total){
    if(total == TAMANHO){
        cout << "Vetor lotado\n";
    } else {
        for( int i = 0; i < TAMANHO; i++){
            if(vetor[i] == "branco"){
                vetor[i] = nome;
                total ++;
                break;
            }
        }
    }
    return total;
}

void exibir(string vetor[]){
    for(int i =0; i < TAMANHO; i++){
        if(vetor[i] != "branco"){
             cout << vetor[i] << "\n";
        }
    }
}
```
## Desafio: remover um nome da lista criada em C++
### Main
```
#include <cstdlib>
#include <iostream>
#include <string>
#define TAMANHO 10

using namespace std;

#include "utilidades.h"


int main(){
    string vetorNomes[TAMANHO]; 
    inicializar(vetorNomes);
    int totalNomesInseridos = 0;

    totalNomesInseridos = inserir ("Davi", vetorNomes, totalNomesInseridos);
    totalNomesInseridos = inserir ("Eduardo", vetorNomes, totalNomesInseridos);
    totalNomesInseridos = inserir ("Gabriel", vetorNomes, totalNomesInseridos);

    if(totalNomesInseridos>0){
        exibir(vetorNomes);
    } else{
        cout << "Vetor de nomes vazio\n";
    }
   
    string nome;
    cout << "Digite um nome: ";
    getline(cin, nome);
    
    //DESAFIO
    totalNomesInseridos = remover(nome, vetorNomes, totalNomesInseridos);
    exibir(vetorNomes);
    //todo vetor é um ponteiro 

    //CMD: cd downloads > cd Estrutura_de_Dados > dir > g++ .\exemploLista1.cpp -o roda > .\roda.exe


    return 1;
}

```
### Uitlidades.h
```

#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;

void inicializar(string vetor[]){
    for(int i =0; i< TAMANHO; i++){
        vetor[i] = "branco";
    }
}


int inserir(string nome, string vetor[], int total){
    if(total == TAMANHO){
        cout << "Vetor lotado\n";
    } else {
        for( int i = 0; i < TAMANHO; i++){
            if(vetor[i] == "branco"){
                vetor[i] = nome;
                total ++;
                break;
            }
        }
    }
    return total;
}

void exibir(string vetor[]){
    for(int i =0; i < TAMANHO; i++){
        if(vetor[i] != "branco"){
             cout << vetor[i] << "\n";
        }
    }
}

/// DESAFIO

int remover(string nome, string vetor[], int total){
    for (int i = 0; i <TAMANHO; i++){
        if(vetor[i] == nome){
            vetor[i] = "branco";
            total--;
        }
    }
    return total;
}
```
