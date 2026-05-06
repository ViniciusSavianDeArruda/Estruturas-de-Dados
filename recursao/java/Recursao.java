package recursao.java;

import java.util.ArrayList;

// repeticao/recursao
// A - inicializacao da variavel de controle
// B - teste de parada
// C - transformacao da variavel de controle

public class Recursao {
  static void mostrarSequenciaCrescente(int numero){
    //variavel de controle é o i
    for(int i = 0; i <= numero; i++){
      System.out.println(i);

    }
  }

  static void mostrarSequenciaDecrescente(int numero){
    //variavel de controle => numero
    for(; numero >=0; numero--){
      System.out.println(numero);
    }
  }

  static void mostrarSequenciaDecrescenteR(int numero){
    if(numero >=0){
      System.out.println(numero);
      mostrarSequenciaDecrescenteR( - 1); // ponto de recursao
    }
  }

  static void mostrarSequenciaCrescenteR(int numero){
    if(numero >=0){
      mostrarSequenciaDecrescenteR( - 1); // ponto de recursao
      System.out.println(numero);
    }
  }


  static void mostrarIntervalo(int ini, int fim){
    for(; ini <= fim; ini++){
      System.out.println(ini);

    }
  }

  static void mostrarIntervaloR(int ini, int fim){
    if(ini <= fim){
      System.out.println(ini);

      mostrarIntervaloR(ini + 1, fim);
    }
  }

  static void mostrarLista(ArrayList<Integer> lista){
    //for por indice
    // for(int i = 0; i < lista.size(); i++){
    //   System.out.println(lista.get(i));
    // }

    //for each
    // for(Integer i : lista){
    //   System.out.println(i);
    // }
  }

  static void mostrarListaR(ArrayList<Integer> lista, int numero){
    if(numero > 0){
      mostrarListaR(lista, numero - 1);
      System.out.println(lista.get(numero - 1));
    }
  }

  static void mostrarListaPares(ArrayList<Integer> lista,int numero){
    if(numero > 0){
      mostrarListaPares(lista, numero - 1);
      if(lista.get(numero - 1) % 2 == 0){
        System.out.println(lista.get(numero - 1));
      }
    }
    }

    static void substituirR(ArrayList<Integer> lista, int numero, int valor, int substituto){
      if(numero > 0){
        substituirR(lista, numero - 1, valor, substituto);
        if(lista.get(numero - 1) == valor){
          lista.set(numero - 1, substituto);
        }
      }
    }

  public static void main(String[] args) {
    ArrayList<Integer> lista = new ArrayList<>();
    //lista = [20,20,40]
    lista.add(21);
    lista.add(30);
    lista.add(43);
    
    //mostrarLista(lista);
    //mostrarListaR(lista, lista.size());
    //mostrarListaPares(lista, lista.size());
    substituirR(lista, lista.size(), 30, 100);

    int numero = 3;
    // mostrarSequenciaCrescente(numero);
    // mostrarSequenciaDecrescente(numero);
    // mostrarSequenciaDecrescenteR(numero)
    //mostrarIntervalo(3,6);
    //mostrarIntervaloR(3,6);



  }
  
}
 