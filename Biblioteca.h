#include <vector>
#include <ctime>
#include <cstdlib>
#include <iostream>

using namespace std;

/**
 * @brief Função para popular uma lista com numeros aleatorios
 * 
 * @param lista A lista a ser populada com numeros aleatorios
 * @param quantidadeNumeros A quantidade de numeros a serem gerados aleatoriamente
 * @param faixaInicial A faixa inicial para a geração dos numeros aleatorios
 * @param faixaFinal A faixa final para a geração dos numeros aleatorios
 * 
 */

void popularListaAleatoria(vector<int>& lista, int quantidadeNumeros, int faixaInicial, int faixaFinal){
    // observe o simbolo & na frente da variavel lista, isso acontece pq em c++ se houver alterado na lista é 
    // preciso utilizar o simbolo de enderecamento &
    srand(time(NULL));
    int numeroSorteado;
    for(int i = 0; i < quantidadeNumeros; i++){
        numeroSorteado = faixaInicial + (rand() % faixaFinal);
        lista.push_back(numeroSorteado);
    }
}

/**
 * @brief Função para exibir os numeros de uma lista
 * 
 * @param lista A lista a ser exibida
 */
    
void exibirLista(vector<int> lista){
    for(int i = 0; i < lista.size(); i++){
        cout << lista[i] << '\n';
    }
    cout <<"-----------------------------\n";
    cout << "Tamanho da lista: " << lista.size() << '\n';
}

/**
 * @brief metodo que copia os numeros pares de uma lista para outra lista
 * 
 * @param listaOrigem listaOrigem contem os numeros originais da lista
 * @param listaDestino listaDestino é contem os numeros copiados da lista Original sem ser repetidos
 */

void copiarListaSemRep(vector<int> &listaOriginal, vector<int> &listaResultado) {
    for (int i = 0; i < listaOriginal.size(); i++){
        bool encontrado = false;

        for (int j = 0; j < listaResultado.size(); j++){
            if (listaOriginal[i] == listaResultado[j]){
                encontrado = true;
                break;
            }
        }

        if (!encontrado){
            listaResultado.push_back(listaOriginal[i]);
        }
}

}



