import java.io.*;
import java.util.TreeSet;

public class GerenciadorFiguras {

    /**
     * Carrega um arquivo CSV e adiciona as figuras no TreeSet informado.
     *
     * @param arquivo nome do arquivo CSV
     * @param lista   lista de destino
     */
    public void carregarArquivo(String arquivo, TreeSet<Figura> lista) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                Figura figura = new Figura(dados[0],Integer.parseInt(dados[1]),dados[2],Integer.parseInt(dados[3]),Boolean.parseBoolean(dados[4]));
                lista.add(figura);
            }
        } catch (IOException e) {
            System.out.println("Arquivo " + arquivo + " ainda não existe.");
        }
    }

    /**
     * Salva uma figurinha no arquivo CSV.
     *
     * @param arquivo nome do arquivo
     * @param figura  figurinha a salvar
     */
    public void salvarFigura(String arquivo, Figura figura) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(figura.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo.");
        }
    }

    /**
     * Lista todas as figuras.
     *
     * @param lista lista que será exibida
     */
    public void listar(TreeSet<Figura> lista) {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }
        for (Figura figura : lista) {
            System.out.println(figura);
        }
    }
}
