package listas.java;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

public class Estruturas {

    public static void gerarProcessos(ArrayList<Processo> lista) {
        Scanner sc = new Scanner(System.in);
        Random gerador = new Random();

        int id;
        String descricao;
        Processo tmp;

        while(true){
            id = gerador.nextInt(500);

            System.out.println("Digite a descrição do processo:");
            descricao = sc.nextLine().toUpperCase();

            if(descricao.equals("SAIR")){
                break;
            }

            tmp = new Processo(id, descricao);

            if(!lista.contains(tmp)){
                lista.add(tmp);
            }
        }
    }

    public static void exibirProcessos(ArrayList<Processo> lista) {
        System.out.println("Quantidade de processos: " + lista.size());

        lista.sort((p1, p2) -> p1.descricao.compareTo(p2.descricao));

        System.out.println("Processos ordenados por descrição:");

        for(Processo p : lista){
            System.out.println(p);
        }
    }

    public static void localizarProcessos(ArrayList<Processo> lista) {
        Scanner sc = new Scanner(System.in);
        String descricao;

        System.out.println("Digite parte da descrição para pesquisar:");
        descricao = sc.nextLine().toUpperCase();

        for(Processo p : lista){
            if(p.descricao.contains(descricao)){
                System.out.println(p);
            }
        }
    }

    //Desafio: fazer o remover processos que tenham uma descricao ou expressao
    public static void removerProcessos(ArrayList<Processo> lista) {
      String descricao;
    Scanner scan = new Scanner(System.in);
    System.out.println("Digite parte da descrição para remover processos:");
    descricao = scan.nextLine().toUpperCase();

    Iterator<Processo> it = lista.iterator();

    while (it.hasNext()) {
    Processo p = it.next();

    if (p.descricao.contains(descricao)) {
        it.remove();
    }
}

System.out.println("Lista após remoção:");
for (Processo p : lista) {
    System.out.println(p);
}

}
    public static void main(String[] args) {

        ArrayList<Processo> lista = new ArrayList<>();

        Estruturas.gerarProcessos(lista);
        Estruturas.exibirProcessos(lista);
        Estruturas.localizarProcessos(lista);
        Estruturas.removerProcessos(lista);
    }
}