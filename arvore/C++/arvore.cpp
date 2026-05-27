#include <iostream>
#include <stdlib.h>
using namespace std;

typedef struct no {
    int valor;
    struct no *left;
    struct no *right;
} Arvore;

//classe base para a estrutura de dados de árvore binária
Arvore *inserir(int valor, Arvore *raiz){
    if(raiz){
        if(valor < raiz->valor){
            raiz->left = inserir(valor, raiz->left);
        }else{
            raiz->right = inserir(valor, raiz->right); 
        }
        return raiz;
    } else {
        Arvore *novo = (Arvore*)malloc(sizeof(Arvore));

        if(novo == NULL){
            cout << "Erro de memoria!" << endl;
            exit(1);
        }

        novo->valor = valor;
        novo->left = NULL;
        novo->right = NULL;

        return novo;
    }
}

// RED - pre-fixado ou pre-ordem
void red(Arvore *raiz){
    if(raiz){
        cout << raiz->valor << endl;
        red(raiz->left);
        red(raiz->right);
    }
}

// RDE - infixado ou infix-ordem
void erd(Arvore *raiz){
    if(raiz){
        erd(raiz->left);
        cout << raiz->valor << endl;
        erd(raiz->right);
    }
}

// EDR - pos-fixado ou pos-ordem
void edr(Arvore *raiz){
    if(raiz){
        edr(raiz->left);
        edr(raiz->right);
        cout << raiz->valor << endl;
    }
}

// Método para exibir a árvore de forma hierárquica
void exibir(Arvore *raiz, int nivel){
    if(raiz){
        // tudo para direita
        exibir(raiz->right, nivel + 1);

        // espaços por nível
        for(int i = 0; i < nivel; i++){
            cout << "   ";  // << AQUI está a correção
        }
        cout << raiz->valor << "(" << nivel << ")" << endl;
        // tudo para esquerda
        exibir(raiz->left, nivel + 1);
    }
}

// Método para contar o número total de nós na árvore
int contarNos(Arvore *raiz){
    if(raiz){
        return 1 + contarNos(raiz->left) + contarNos(raiz->right);
    }
    return 0;
}

// Método para contar os números pares na árvore
int contarPares(Arvore *raiz){
    if(raiz){
        if(raiz->valor % 2 == 0)
            return 1 + contarPares(raiz->left) + contarPares(raiz->right);

        return contarPares(raiz->left) + contarPares(raiz->right);
    }
    return 0;
}

// Método para contar os nós folhas na árvore
int contarFolhas(Arvore *raiz){
    if(raiz){
        if(raiz->left == NULL && raiz->right == NULL)
            return 1;

        return contarFolhas(raiz->left) + contarFolhas(raiz->right);
    }
    return 0;
}

// Método para verificar se um valor está contido na árvore
int contido(int valor, Arvore *raiz){
    if(raiz == NULL) return 0;

    if(raiz->valor == valor) return 1;

    if(valor < raiz->valor)
        return contido(valor, raiz->left);
    else
        return contido(valor, raiz->right);
}

// Método para contar os nós que não são folhas na árvore
int contarNaoFolhas(Arvore *raiz){
    if(raiz == NULL) return 0;

    if(raiz->left == NULL && raiz->right == NULL)
        return 0;

    return 1 + contarNaoFolhas(raiz->left) + contarNaoFolhas(raiz->right);
}


int main(){
    Arvore *raiz = NULL;

    raiz = inserir(100, raiz);
    raiz = inserir(50, raiz);
    raiz = inserir(200, raiz);
    raiz = inserir(20, raiz);
    raiz = inserir(70, raiz);
    raiz = inserir(250, raiz);
    raiz = inserir(150, raiz);


    //erd(raiz);
    //edr(raiz);
    //red(raiz);
    exibir(raiz,0);

    //cout << "Total de elementos:" << contarNos(raiz) << endl;
    cout << "Quantidade de pares: " << contarPares(raiz) << endl;
    cout << "Quantidade de folhas: " << contarFolhas(raiz) << endl;
    cout << "Valor 70 contido na arvore? " << (contido(70, raiz) ? "1" : "0") << endl;
    cout << "Quantidade de nos nao folhas: " << contarNaoFolhas(raiz) << endl;

    return 0;
}

// - Desafios
//      - Refatorar os códigos trabalhados em aula sobre árvores
//      - método que conte os números pares 
//      - método que conte os nodos folhas
//      - método que retorne true (1) se valor esta na árvore... ou retorne false (0) se valor não está na árvore int contido(int valor, Arvore *raiz)
//      - método que conte os nodos NÃO folhas