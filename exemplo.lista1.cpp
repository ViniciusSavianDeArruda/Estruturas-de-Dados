#include <cstdlib>
#include <iostream>
#include <string>
#define TAMANHO 1000

#include "utilidade.h"

using namespace std;

int main(){
    string VetorNomes[TAMANHO];
    inicializar(VetorNomes);
    int totalNomesInseridos = 0;

    totalNomesInseridos = inserir("Davi", VetorNomes, totalNomesInseridos);
    totalNomesInseridos = inserir("Eduardo", VetorNomes, totalNomesInseridos);
    totalNomesInseridos = inserir("Gabriel", VetorNomes, totalNomesInseridos);
    
    if(totalNomesInseridos > 0){
        exibir(VetorNomes);
    } else{
        cout <<"Vetor vazio\n";
    }

    return 1;
}