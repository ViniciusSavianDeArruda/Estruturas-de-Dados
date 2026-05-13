import java.util.ArrayList;
import java.util.Random;

class RecursaoEx {
  public static void popular(ArrayList<Integer> lista, int quantidade) {
    Random gerador = new Random();
    for(int i = 0; i < quantidade;i++){
      int numero = gerador.nextInt(100);
      lista.add(i, numero);
    }
    }

    public static void exibir(ArrayList<Integer> lista) {
      for(int i = 0; i < lista.size(); i++){
        System.out.println(lista.get(i));
      }
    }

    public static void exibirR(ArrayList<Integer> lista, int numero) {
      if(numero > 0){
        //codigo antes do empilhamento
        System.out.println(lista.get(numero - 1));
        exibirR(lista, numero - 1);
        //codigo depois do desempilhamento
    }
  }
  
   public static int somarR(ArrayList<Integer> lista, int numero) {
        if (numero == 0) {
            return 0;
        }
        return lista.get(numero - 1) + somarR(lista, numero - 1);
    }

    public static int contarParesR(ArrayList<Integer> lista, int numero) {
        if (numero == 0) {
            return 0;
        }
        if (lista.get(numero - 1) % 2 == 0) {
            return 1 + contarParesR(lista, numero - 1);
        }
        return contarParesR(lista, numero - 1);
    }

    public static void main(String[] args) {
      ArrayList<Integer> lista = new ArrayList<>();
      int quantidade = 3;
      popular(lista, quantidade);
      // exibir(lista);
      exibirR(lista, lista.size());
      somarR(lista, lista.size());

      System.out.println("A soma dos elementos da lista eh:" + somarR(lista, lista.size()));
      System.out.println("A quantidade de de pares  na lista eh:" + contarParesR(lista, lista.size()));
    }
}

/*
Exercicios de fixacao sobre o codigo base gerado. Faca metodos recursivas que:
1- receba uma lista, seu tamanho, valor de pesquisa. Caso o valor de pesquisa ocorra na lsita, retornar quantas vezes ele aparece

2- receba um lista, seu tamanho, valor de pesquisa, valor de substituicao. Caso o valor ocorra na lista, substituir o valor de pesquisa pelo vetor de substituicao

3- receba uma lista, seu tamanho e retorne TRUE se a ordenada, FALSE se lista desordenada

4-receba uma lista seu tamanho. o metodo os numeros multiplos de 4
*/
