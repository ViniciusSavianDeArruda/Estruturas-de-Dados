package Java;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PrincipalJava {
    public static void main(String[] args) {

        List<Clima> lista = new ArrayList<>();

        String nomeBase = "PrevisoesClimaticas/baseClimatica.csv";

        try (BufferedReader leitor = new BufferedReader(
                new FileReader(nomeBase, StandardCharsets.UTF_8))) {

            String linha;

            // Lê o arquivo linha por linha até o final
            while ((linha = leitor.readLine()) != null) {

                // Divide a linha em partes (ano, mês, temperatura, precipitação)
                String[] dadosLinha = linha.split(",");

                // Cria um objeto Clima com os dados da linha
                Clima objClima = new Clima(
                        dadosLinha[0],
                        dadosLinha[1],
                        dadosLinha[2],
                        dadosLinha[3]
                );

                // Evita adicionar dados repetidos na lista
                if (!lista.contains(objClima)) {
                    lista.add(objClima);
                }
            }

            // Mostra todos os dados lidos
            for (Clima item : lista) {
                System.out.println(item);
            }


            // DESAFIO: descobrir o mês com mais chuvA
            double maiorChuva = -1; // guarda o maior valor encontrado
            String mesMaior = "";   // guarda o mês com maior chuva

            // percorre cada registro
            for (Clima atual : lista) {

                double soma = 0; 

                // percorre novamente a lista para somar o mesmo mês
                for (Clima c : lista) {

                    // verifica se é o mesmo mês
                    if (c.mes.equalsIgnoreCase(atual.mes)) {

                        // converte o texto (muita, média...) para número
                        soma += getValorPrecipitacao(c.precipitacao);
                    }
                }

                // verifica se esse mês é o que mais choveu até agora
                if (soma > maiorChuva) {
                    maiorChuva = soma;
                    mesMaior = atual.mes;
                }
            }

            // Mostra o resultado final
            System.out.println("\nMês com mais chuva: " + mesMaior);
            System.out.println("Total de chuva: " + maiorChuva);

        } catch (Exception e) {
            // Caso dê erro ao ler o arquivo
            System.err.println("Ocorreu algum erro... " + e.getMessage());
        }
    }

    // Método que transforma texto em número para poder somar
    public static double getValorPrecipitacao(String p) {

        // transforma tudo em minúsculo para evitar erro
        p = p.toLowerCase();

        // define valores para cada tipo de chuva
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