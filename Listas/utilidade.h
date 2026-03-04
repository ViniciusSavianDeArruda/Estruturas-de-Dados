#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;

//definir o tamanho do vetor
void inicializar(string vetor[]){
    for(int i = 0; i < TAMANHO; i++){
        vetor[i] = "vazio";
    }
}
//inserir um nome na lista
int inserir(string nome, string vetor[], int totalNomesInseridos){
    if(totalNomesInseridos == TAMANHO){
        cout << "vetor lotado\n";
    } else{
        for(int i = 0; i < TAMANHO; i++){
            if(vetor[i] == "vazio"){
                vetor[i] = nome;
                totalNomesInseridos++;
                break;
            }
        }
    }

    return totalNomesInseridos;
}

//exibir os nomes da lista
void exibir(string vetorNomes[]){
    for(int i = 0; i < TAMANHO; i++){
        if(vetorNomes[i] != "vazio"){
            cout << vetorNomes[i] << '\n';
        }
    }


    
    
}