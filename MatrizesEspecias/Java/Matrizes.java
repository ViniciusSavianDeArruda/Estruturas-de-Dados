package MatrizesEspecias.Java;

import java.util.List;

public class Matrizes {

    public static void inicializarMatrizesInteiro(int matriz[][], int qtdLinhas, int qtdColunas) {
        for(int lin = 0; lin < qtdLinhas; lin++){
            for(int col = 0; col < qtdColunas; col++){
                matriz[lin][col] = 0;
            }
        }
    }

    public static void exibirMatriz(int matriz[][], int qtdLinhas, int qtdColunas) {
        for(int lin = 0; lin < qtdLinhas; lin++){
            for(int col = 0; col < qtdColunas; col++){
                System.out.print(matriz[lin][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void converter(int matriz[][], int qtdLinhas, int qtdColunas, List<Dado> matrizEspecial) {
        for(int lin = 0; lin < qtdLinhas; lin++){
            for(int col = 0; col < qtdColunas; col++){
                if(matriz[lin][col] != 0){
                    matrizEspecial.add(new Dado(matriz[lin][col], lin, col));
                }
            }
        }
    }

    public static void exibirLista(List<Dado> matrizEspecial) {
        for(Dado item : matrizEspecial){
            System.out.println(item);
        }
        System.out.println();
    }

} // fecha a classe Matrizes
//Saber urgente 
//     - objeto
//         - todo o objeto de classe tem um endereço de memória
//         todo objeto passado como parametro/argumento é passado sua referencia (endereco)