import java.util.ArrayList;
import java.util.Scanner;
public class Exemplo_lista1{

    public static void main(String[] args) {
        ArrayList<String> listaNomes = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String nome;

        listaNomes.add("Guilherme");
        listaNomes.add("Bruno");
        listaNomes.add("Maria");

        System.out.println(listaNomes);

        if(listaNomes.size() !=0){
            System.out.print("Digite um nome:");
            nome = teclado.nextLine();
            if(listaNomes.contains(nome)){
                listaNomes.remove(nome);
            }else{
                System.out.println("O nome não existe na lista.");
            }

            System.out.println("Tamanho da lista: " + listaNomes.size());
            System.out.println(listaNomes);
        }
    }
}