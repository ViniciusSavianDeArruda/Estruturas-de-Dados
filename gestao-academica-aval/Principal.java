import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        GestaoAlunos gestao = new GestaoAlunos();
        gestao.carregar("alunos.csv");

        Scanner sc = new Scanner(System.in);

        int op;

        //Utilizei do-while e switch-case para organizar melhor a aplicação e aprimorar a usabilidade, permitindo que o usuário escolha as opções no menu
        do {
            System.out.println("\n MENU ");
            System.out.println("1 - Listar alunos");
            System.out.println("2 - Ordenar por nome");
            System.out.println("3 - Ordenar por ano");
            System.out.println("4 - Buscar aluno");
            System.out.println("5 - Quantidade por ano");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    gestao.listar();
                    break;

                case 2:
                    gestao.ordenarPorNome();
                    gestao.listar();
                    break;

                case 3:
                    gestao.ordenarPorAno();
                    gestao.listar();
                    break;

                case 4:
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();

                    Aluno aluno = gestao.buscarPorNome(nome);

                    if (aluno != null) {
                        System.out.println(aluno);
                    } else {
                        System.out.println("Aluno não encontrado");
                    }
                    break;

                case 5:
                    gestao.contarPorAno();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (op != 0);

        sc.close();
    }
}