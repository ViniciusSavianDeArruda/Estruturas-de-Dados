package arvore;

import java.util.ArrayList;
import java.util.TreeSet;

public class Arvore {
    public static void main(String[] args) {

        int quantidade = 1_000_000;

        TreeSet<Integer> arvore = new TreeSet<>();
        ArrayList<Integer> lista = new ArrayList<>();

        // ===================== TREESET =====================
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < quantidade; i++) {
            int numero = (int) (Math.random() * quantidade);
            arvore.add(numero);
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo TreeSet: " + (fim - inicio) + " ms");

        // ===================== ARRAYLIST =====================
        inicio = System.currentTimeMillis();

        for (int i = 0; i < quantidade; i++) {
            int numero = (int) (Math.random() * quantidade);
            lista.add(numero);
        }

        fim = System.currentTimeMillis();
        System.out.println("Tempo ArrayList: " + (fim - inicio) + " ms");

        // ===================== TESTE EXTRA =====================
        System.out.println("\nTamanho TreeSet: " + arvore.size());
        System.out.println("Tamanho ArrayList: " + lista.size());
    }
}