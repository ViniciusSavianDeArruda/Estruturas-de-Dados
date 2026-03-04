/*Exercicio de revisao em c 

1- um diabetico tem fator de correcao(boulus) de carboidrato. O sistema precisa solicitar o boulus de correcao(dg/ml por carboidrato) e a
quantidade de carboidrato ingerido.
Por exemplo,

#entrada
Alexandre
boulusAlimentar = 15
quantidadeInsulinaMaxima = 13
carboidrato = 30 g

#Processamento e saida
quantidadeInsulina = carboidrato / boulus
quantidademaximacarboidrado = boulus * quantidadeInsulinaMaxima
restanteInsulinaDia = quantidadeInsulinaMaxima - quantidadeInsulina
restanteCarboidratoDia = quantidadeMaximaCarboidrado - carboidrato
*/

#include <stdio.h>
#include <stdlib.h>

int main(){

    //variaveis de entrada
    char nome[100];
    int boulusAlimentar;
    int quantidadeInsulinaMaxima;
    int carboidrato;

    //variaveis de processamento e saida
    int quantidadeInsulina;
    int quantidadeMaximaCarboidrato;
    int restanteInsulinaDia;
    int restanteCarboidratoDia;

    // Dados de entrada
    printf("Ola, Informe seu dados:");
    printf("Nome: ");
    gets(nome);

    printf("Boulus Alimentar (dg/ml por carboidrato): ");
    scanf("%d", &boulusAlimentar);

    printf("Quantidade Insulina Maxima (unidades): ");
    scanf("%d", &quantidadeInsulinaMaxima);

    printf("Carboidrato (g): ");
    scanf("%d", &carboidrato);

    //dados de processamento
    printf("Dados de Processamento e Saida:\n");
    quantidadeInsulina = (int)carboidrato / boulusAlimentar;
    quantidadeMaximaCarboidrato = boulusAlimentar * quantidadeInsulinaMaxima;
    restanteInsulinaDia = quantidadeInsulinaMaxima - quantidadeInsulina;
    restanteCarboidratoDia = quantidadeMaximaCarboidrato - carboidrato;
   
    //saida dos dados
    printf("Quantidade de Insulina para essa refeicao: %d\n", quantidadeInsulina);
    printf("Quantidade Maxima de Carboidrato para o dia: %d\n", quantidadeMaximaCarboidrato);
    printf("Restante de Insulina para o dia: %d\n", restanteInsulinaDia);
    printf("Restante de Carboidrato para o dia: %d\n", restanteCarboidratoDia);

    return 0;
}


