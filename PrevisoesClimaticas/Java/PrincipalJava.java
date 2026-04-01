package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

 public class PrincipalJava {

    /**
     * método principal que inicia o programa
     */
    public static void main(String[] args) {

        // caminho do arquivo csv que será lido
        String nomeBase = "PrevisoesClimaticas/baseClimatica.csv";

        // chama o método que lê o arquivo e retorna uma lista de objetos clima
        List<Clima> lista = lerArquivo(nomeBase);

        // mostra todos os dados carregados
        mostrarDados(lista);

        // calcula qual mês teve mais chuva
        calcularMesMaisChuvoso(lista);
    }

    /**
     * lê o arquivo csv e transforma cada linha em um objeto Clima
     */
    public static List<Clima> lerArquivo(String nomeBase) {

        // lista onde serão armazenados os dados do arquivo
        List<Clima> lista = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(
                new FileReader(nomeBase, StandardCharsets.UTF_8))) {

            String linha;

            // lê o arquivo linha por linha até chegar no final
            while ((linha = leitor.readLine()) != null) {

                // separa os dados usando a vírgula
                String[] dadosLinha = linha.split(",");

                // evita erro caso a linha esteja incompleta
                if (dadosLinha.length < 4) continue;

                // cria um objeto clima com os dados da linha
                Clima objClima = new Clima(
                        dadosLinha[0], // ano
                        dadosLinha[1], // mês
                        dadosLinha[2], // temperatura
                        dadosLinha[3]  // precipitação
                );

                // verifica se já existe na lista (evita duplicados)
                if (!lista.contains(objClima)) {
                    lista.add(objClima);
                }
            }

        } catch (Exception e) {
            // caso dê erro ao abrir ou ler o arquivo
            System.err.println("erro ao ler arquivo: " + e.getMessage());
        }

        return lista;
    }

    /**
     * percorre a lista e imprime todos os dados no console
     */
    public static void mostrarDados(List<Clima> lista) {

        System.out.println("\ndados:\n");

        // percorre a lista usando for-each
        for (Clima item : lista) {
            System.out.println(item);
        }
    }

    /**
     * calcula qual mês teve a maior quantidade de chuva
     * faz isso somando a chuva de todos os anos para cada mês
     */
    public static void calcularMesMaisChuvoso(List<Clima> lista) {

        double maiorChuva = -1; 
        String mesMaior = "";   

        // percorre cada elemento da lista
        for (Clima atual : lista) {

            double soma = 0; 

            // percorre novamente a lista para comparar os meses
            for (Clima c : lista) {

                // verifica se é o mesmo mês (ignora maiúsculo/minúsculo)
                if (c.mes.equalsIgnoreCase(atual.mes)) {

                    // soma o valor da precipitação convertido para número
                    soma += getValorPrecipitacao(c.precipitacao);
                }
            }

            // verifica se essa soma é maior que a anterior
            if (soma > maiorChuva) {
                maiorChuva = soma;
                mesMaior = atual.mes;
            }
        }

        // mostra o resultado final
        System.out.println("\nresultado:\n");
        System.out.println("mes com mais chuva: " + mesMaior);
        System.out.println("total de chuva: " + maiorChuva);
    }

    /**
     * converte o texto da precipitação em número
     * isso permite fazer cálculos (somar chuva)
     */
    public static double getValorPrecipitacao(String p) {

        // transforma em minúsculo para evitar erro de comparação
        p = p.toLowerCase();

        // define um valor para cada tipo de chuva
        switch (p) {
            case "muita":
                return 3;
            case "média":
            case "media":
                return 2;
            case "pouca":
                return 1;
            case "nada":
                return 0;
            default:
                return 0;
        }
    }
}