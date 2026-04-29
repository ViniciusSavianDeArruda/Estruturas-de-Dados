import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Classe responsável pela gestão dos alunos.
 * Realiza operações como carregamento de arquivo, ordenação,
 * busca e geração de relatórios por ano de ingresso.
 */
public class GestaoAlunos {

    private List<Aluno> alunos = new ArrayList<>();

    /**
     * Carrega os alunos a partir de um arquivo CSV.
     * Cada linha do arquivo representa um aluno.
     *
     * @param caminho caminho do arquivo alunos.csv
     */
    public void carregar(String caminho) {

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;

            // Lê o arquivo linha por linha
            while ((linha = br.readLine()) != null) {

                // Divide a linha em partes: nome, curso, sexo e ano
                String[] dados = linha.split(",");

                alunos.add(new Aluno(
                        dados[0],
                        dados[1],
                        dados[2],
                        Integer.parseInt(dados[3])
                ));
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    /**
     * Exibe todos os alunos cadastrados no sistema.
     */
    public void listar() {
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }

    /**
     * Ordena a lista de alunos em ordem alfabética pelo nome.
     */
    public void ordenarPorNome() {

        // Ordenação baseada no nome ignorando maiúsculas/minúsculas
        Collections.sort(alunos, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return a1.getNome().compareToIgnoreCase(a2.getNome());
            }
        });
    }

    /**
     * Ordena a lista de alunos pelo ano de ingresso (crescente).
     */
    public void ordenarPorAno() {

        // Ordena comparando valores numéricos do ano
        Collections.sort(alunos, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return Integer.compare(a1.getAnoIngresso(), a2.getAnoIngresso());
            }
        });
    }

    /**
     * Busca um aluno pelo nome exato (ignorando maiúsculas/minúsculas).
     *
     * @param nome nome do aluno a ser buscado
     * @return objeto Aluno encontrado ou null caso não exista
     */
    public Aluno buscarPorNome(String nome) {

        // Percorre toda a lista procurando o nome informado
        for (Aluno a : alunos) {

            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Gera um relatório com a quantidade de alunos por ano de ingresso.
     * O resultado é exibido em ordem crescente de ano.
     */
    public void contarPorAno() {

        // Mapa: chave = ano | valor = quantidade de alunos
        Map<Integer, Integer> contagem = new HashMap<>();

        for (Aluno a : alunos) {

            int ano = a.getAnoIngresso();

            // Se o ano já existe incrementa, senão cria com 1
            contagem.put(
                ano,
                contagem.getOrDefault(ano, 0) + 1
            );
        }

        // Converte as chaves do Map para lista para poder ordenar
        List<Integer> anos = new ArrayList<>(contagem.keySet());

        Collections.sort(anos);

        System.out.println("\nAlunos por ano");

        for (Integer ano : anos) {
            System.out.println(ano + " -> " + contagem.get(ano));
        }
    }
}