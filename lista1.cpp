#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include "Biblioteca.h"

using namespace std;

int main(){

    srand(time(NULL)); // inicializa o gerador de números aleatórios

    vector<int> listaNumeros;
    vector<int> listaResultado;

    int quantidadeNumeros;
    int faixaInicial = 10;
    int faixaFinal = 50;

    cout << "Digite a quantidade de numeros a serem gerados: ";
    cin >> quantidadeNumeros;

    popularListaAleatoria(listaNumeros, quantidadeNumeros, faixaInicial, faixaFinal);
    
    copiarListaSemRep(listaNumeros, listaResultado);
    exibirLista(listaResultado);
    
    return 0;
}