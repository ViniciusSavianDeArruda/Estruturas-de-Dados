package Pilha.Java;
import java.util.Stack;

public class exemploPilha {
    public static void main(String[] args) {
    Stack<Integer> pilha = new Stack<>();

        pilha.push(15);
        pilha.push(5);
        pilha.push(100);
        pilha.push(45);

        pilha.pop(); // remove o topo

        System.out.println(pilha.contains(45));
        System.out.println("Topo eh... " + pilha.peek()); // mostra o valor do topo sem remover
    }
}