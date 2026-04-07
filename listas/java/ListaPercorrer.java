package listas.java;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPercorrer {
  public static void main(String[] args) {
    ArrayList<Integer> lista = new ArrayList<>();

    lista.add(45);
    lista.add(2);
    lista.add(42);
    lista.add(23);

    //PERCURSOS EM LISTA
    //percorrer via indice  a lista, NUNCA USAR PARA REMOVER ELEMENTOS DA LISTA PQ ELE ALTERA O TAMANHO DA LISTA
    System.out.println("Percurso via indice:");
    for(int i = 0; i < lista.size(); i++){
      System.out.println(lista.get(i)); // em c seria lista[i]
    }

    //percorrer via objeto NAO PODE USAR PARA REMOVER ELEMENTOS DA LISTA PQ ELE ALTERA O TAMANHO DA LISTA
    System.out.println("Percurso via objeto:");
    for(Integer p : lista){
      System.out.println(p);
    }

    //percorrer via iterator, USAR PARA REMOVER ELEMENTOS DA LISTA E alterar o tamanho da lista em tempo de execucao é como eu criasse virtualmente um ponteiro para a lista = interator é um objeto que sabe percorrer a lista
    System.out.println("Percurso via iterator:");
    Iterator<Integer> it = lista.iterator();
    while (it.hasNext()) {
      int numero = it.next();
      System.out.println(numero);
    }


  }
  
}
