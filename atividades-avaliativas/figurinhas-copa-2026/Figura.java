/**
 * Representa uma figurinha do álbum da Copa 2026.
 * Cada figurinha possui seleção, número,
 * descrição, quantidade e indicação se é rara.
 */
public class Figura implements Comparable<Figura> {

    private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean rara;

    public Figura(String nomeSelecao,
                  int numeroFigura,
                  String descricao,
                  int quantidade,
                  boolean rara) {

        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    public String getNomeSelecao() {
        return nomeSelecao;
    }

    public int getNumeroFigura() {
        return numeroFigura;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isRara() {
        return rara;
    }

    public String toCSV() {

        return nomeSelecao + ","
                + numeroFigura + ","
                + descricao + ","
                + quantidade + ","
                + rara;
    }

    @Override
    public int compareTo(Figura outra) {

        int compararSelecao =
                this.nomeSelecao.compareTo(
                        outra.nomeSelecao);

        if (compararSelecao != 0) {
            return compararSelecao;
        }

        return Integer.compare(
                this.numeroFigura,
                outra.numeroFigura);
    }

    @Override
    public String toString() {

        return numeroFigura
                + " - "
                + descricao
                + " - "
                + nomeSelecao
                + " - qtd: "
                + quantidade
                + " - rara: "
                + rara;
    }
}
