    package Fila.Java;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;

    public class Chamando {
        public static void main(String[] args) {
            Queue<Integer> filaNormal = new LinkedList<>();
            Queue<Integer> filaPrioritaria = new LinkedList<>();

            int contarNormal = 1;
            int contarPrioritaria = 500;
            int totalAtendidos = 1;

            Scanner scanner = new Scanner(System.in);
            String opcao = "";
            String qualFila = "";

            do {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Ficha Normal");
                System.out.println("2 - Ficha Prioritária");
                System.out.println("3 - Chamar ficha");
                System.out.println("4 - Mostrar fichas");
                System.out.println("5 - Sair");
                opcao = scanner.nextLine();

                switch(opcao) {
                    case "1":
                        System.out.println("Ficha Normal: " + contarNormal);
                        filaNormal.offer(contarNormal);
                        contarNormal++;
                        break;

                    case "2":
                        System.out.println("Ficha Prioritária: " + contarPrioritaria);
                        filaPrioritaria.offer(contarPrioritaria);
                        contarPrioritaria++;
                        break;

                    case "3":
                        int fichaAtendida = -1;

                        // define qual fila será atendida
                        if(totalAtendidos % 3 == 0){
                            qualFila = "PRIORITÁRIA";
                        } else {
                            qualFila = "NORMAL";
                        }

                        // mantém tua lógica
                        if(qualFila.equals("PRIORITÁRIA") && !filaPrioritaria.isEmpty()){
                            fichaAtendida = filaPrioritaria.poll();
                        } 
                        else if(!filaNormal.isEmpty()){ // corrigido aqui
                            fichaAtendida = filaNormal.poll();
                        }

                        // exibe a ficha chamada
                        if(fichaAtendida != -1){
                            totalAtendidos++; // só incrementa uma vez
                            System.out.println("Chamando ficha... " + qualFila + ": " + fichaAtendida);
                        } else {
                            System.out.println("Nenhuma ficha para chamar.");
                        }
                        break;

                    case "4":
                        System.out.println("Fila Normal: " + filaNormal);
                        System.out.println("Fila Prioritária: " + filaPrioritaria);
                        break;

                    case "5":
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

            } while (!opcao.equals("5"));

            scanner.close();
        }
    }