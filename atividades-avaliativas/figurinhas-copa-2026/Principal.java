import java.util.Scanner;
import java.util.TreeSet;

/**
 * Classe principal da aplicação de gerenciamento de figurinhas.
 */
public class Principal {

    static Scanner sc = new Scanner(System.in);

    static GerenciadorFiguras gerenciador = new GerenciadorFiguras();

    static TreeSet<Figura> repetidasPessoais = new TreeSet<>();

    static TreeSet<Figura> desejadasPessoais = new TreeSet<>();

    public static void main(String[] args) {
        // Recupera os dados já gravados em execuções anteriores
        gerenciador.carregarArquivo("figuras_repetidas_pessoais.csv", repetidasPessoais);
        gerenciador.carregarArquivo("figuras_desejadas_pessoais.csv", desejadasPessoais);

        int opcao;
        do {
            mostrarMenu();
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarRepetida();
                    break;
                case 2:
                    gerenciador.listar(repetidasPessoais);
                    break;
                case 3:
                    cadastrarDesejada();
                    break;
                case 4:
                    gerenciador.listar(desejadasPessoais);
                    break;
                case 5:
                    // Repetidas do outro x minhas desejadas: o que ELE tem e EU quero
                    carregarRepetidasOutro();
                    break;
                case 6:
                    // Desejadas do outro x minhas repetidas: o que ELE quer e EU tenho
                    carregarDesejadasOutro();
                    break;
                case 7:
                    System.out.println("Encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7); // Repete enquanto o usuário não pedir para sair
    }

    /**
     * Exibe no console as opções disponíveis no menu principal.
     */
    public static void mostrarMenu() {
        System.out.println("\n1 - cadastrar repetidas");
        System.out.println("2 - listar repetidas");
        System.out.println("3 - cadastrar desejadas");
        System.out.println("4 - listar desejadas");
        System.out.println("5 - carregar figuras repetidas OUTRO");
        System.out.println("6 - carregar figuras desejadas OUTRO");
        System.out.println("7 - sair");
    }

    /**
     * Solicita ao usuário, campo a campo, os dados de uma figurinha
     * e constrói o objeto correspondente.
     *
     * @return uma nova {@link Figura} preenchida com os dados informados
     */
    public static Figura lerFigura() {
        System.out.print("Seleção: ");
        String selecao = sc.nextLine();

        System.out.print("Número: ");
        int numero = Integer.parseInt(sc.nextLine());

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(sc.nextLine());

        System.out.print("Rara: ");
        boolean rara = Boolean.parseBoolean(sc.nextLine());

        return new Figura(selecao, numero, descricao, qtd, rara);
    }

    /**
     * Cadastra uma figurinha repetida: lê os dados, adiciona à coleção
     * em memória e grava no arquivo CSV de repetidas.
     */
    public static void cadastrarRepetida() {
        Figura figura = lerFigura();
        repetidasPessoais.add(figura);
        gerenciador.salvarFigura("figuras_repetidas_pessoais.csv", figura);
    }

    /**
     * Cadastra uma figurinha desejada: lê os dados, adiciona à coleção
     * em memória e grava no arquivo CSV de desejadas.
     */
    public static void cadastrarDesejada() {
        Figura figura = lerFigura();
        desejadasPessoais.add(figura);
        gerenciador.salvarFigura("figuras_desejadas_pessoais.csv", figura);
    }

    /**
     * Carrega as figuras repetidas de outra pessoa, lista todas elas e
     * mostra quais coincidem com as MINHAS desejadas (trocas a meu favor).
     */
    public static void carregarRepetidasOutro() {
        System.out.print("Nome do arquivo de repetidas do OUTRO: ");
        String arquivo = sc.nextLine();
        gerenciador.carregarOutroEMostrarMatches(arquivo, desejadasPessoais);
    }

    /**
     * Carrega as figuras desejadas de outra pessoa, lista todas elas e
     * mostra quais coincidem com as MINHAS repetidas (o que posso oferecer).
     */
    public static void carregarDesejadasOutro() {
        System.out.print("Nome do arquivo de desejadas do OUTRO: ");
        String arquivo = sc.nextLine();
        gerenciador.carregarOutroEMostrarMatches(arquivo, repetidasPessoais);
    }
}
