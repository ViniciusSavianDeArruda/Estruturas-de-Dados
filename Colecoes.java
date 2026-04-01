/* Coleções em Java 
        -List -> vector, arrayList, linkedList
            - lista para armazenamento de dados, remocao, busca e relatorios(ordenados)
        -stack(Pilha) - LIFO -> Last in, first out - o ultimo a entrar é o primeiro a sair
            - topo - peak
            - ha somente duas operacoes classicas: REMOVER do topo e INSERIR NO TOPO
                push() - inserir no topo
                pop() - remover do topo - NAO SE ESCOLHE QUEM SERA REMOVIDO, A REMOCAO ACONTECE NO TOPO
            - outro metodos basicos:
                - peek() - mostra o valor do topo sem remover
                - isEmpty() - verifica se a pilha esta vazia
                - size() - mostra o numero de elementos na pilha
                - contains() - verifica se um elemento esta presente na pilha

        - Queue(Fila) - FIFO -> First in, first out - o primeiro a entrar é o primeiro a sair
        - DOIS PONTEIROS : um para o cabeca/inicio(remover); outro para a cauda/final(inserir)
        -Novamente, ha somente duas operacoes classicas: REMOVER DO INICIO e INSERIR NO FINAL
            - add() - inserir no final
            - remove() - remover do inicio -
            - outro metodos basicos:
                - peek() - mostra o valor do inicio da fila sem remover
                - isEmpty() - verifica se a fila esta vazia
                - size() - mostra o numero de elementos na fila
                - contains() - verifica se um elemento esta presente na fila
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Colecoes {
    public static void main(String[] args) {
        
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(15);
        lista.add(5);
        lista.add(100);
        lista.add(45);

        System.out.println(lista);

        lista.remove(Integer.valueOf(100)); // remove o valor 100

        System.out.println(lista.contains(100)); // false

        // Iterando sobre a lista usando um loop tradicional FOCA NO INDICE
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }

        //FOCA NO ELEMENTO
        // Iterando sobre a lista usando um loop for-each 
        for(Integer i: lista){
            System.out.println(i);
        }
        
        // FOCO NO INTERATOR DO ELEMENTO
        Iterator<Integer> i = lista.iterator();
        while (i.hasNext()) { // enquanto o i tiver um proximo elemento
            System.out.println(i.next()); // mostra o proximo elemento e avanca o iterator para o proximo elemento
        }
        

        /*
        Stack<Integer> pilha = new Stack<>();

        pilha.push(15);
        pilha.push(5);
        pilha.push(100);
        pilha.push(45);

        pilha.pop(); // remove o topo

        System.out.println(pilha.contains(45));
        System.out.println("Topo eh... " + pilha.peek()); // mostra o valor do topo sem remover
        */

        /*
        Queue<Integer> fila = new LinkedList<>();
        fila.add(15);
        fila.offer(5); // push para filha - outra forma de inserir no final da fila
        fila.add(100);
        fila.add(45);
        System.out.println(fila);

        fila.poll(); // remove do inicio da fila - outra forma de remover do inicio da fila

        fila.remove();
        System.out.println(fila.contains(15));
        System.out.println(fila.peek()); // mostra o valor do inicio da fila sem remover
        */
    }
}