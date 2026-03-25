
# Aula de Desafio
- ler arquivo (vamos pular)
- ler linha a linha
- para cada linha lida precisa-se splitar (separar)
- inserir em objeto
- inserir em lista
### Principal Python
```
from clima import Clima

lista = []
nome_base = "base.csv"

try:

    leitor = open(nome_base, "r", encoding="utf-8")

    for linha in leitor:
        dados_linha = linha.split(",")
        obj_clima = Clima(dados_linha[0], dados_linha[1], dados_linha[2], dados_linha[3])

        if obj_clima not in lista:
            lista.append(obj_clima)


    for item in lista:
        print(item, end=" ")

    leitor.close()
except Exception as e:
    print("Ocorreu algum erro", e)
```
### Classe Python
```
class Clima:
    def __init__(self, ano, mes, temperatura, precipitacao): # type: ignore
        self.ano = ano
        self.mes = mes
        self.temperatura = temperatura
        self.precipitacao = precipitacao

    def __str__(self):
        return f"Dados climaticos - Ano: {self.ano}, Mês: {self.mes}, Temperatura: {self.temperatura}, Precipitação: {self.precipitacao}"

    def __eq__(self, object):

        if not isinstance(object, self.__class__):
            return NotImplemented
        return self.ano == object.ano and self.mes == object.mes
```
### Principal Java
```
import java.util.ArrayList;

public class PrincipalClima {
    
    public static void main(String[] args) {

        ArrayList<Clima> lista = new ArrayList<Clima>();

        //simulando que estamos lendo linha a linha do arquivo
        //primeira linha
        String linha = "2020,Janeiro,Quente,muita";
        String[] dadoslinha = linha.split(",");
        Clima objClima = new Clima(dadoslinha[0], dadoslinha[1], dadoslinha[2], dadoslinha[3]);


        if(!lista.contains(objClima)){
            lista.add(objClima);
        }

        //segunda linha
        linha = "2020,Janeiro,Frio,pouca";
        dadoslinha = linha.split(",");
        objClima = new Clima(dadoslinha[0], dadoslinha[1], dadoslinha[2], dadoslinha[3]);

        
        if(!lista.contains(objClima)){
            lista.add(objClima);
        }

        for(Clima c : lista){
            System.out.println(c);
        }

    }
    
}
```
### Classe Java
```
public class Clima{
    public String ano;
    public String mes;
    public String temperatura;
    public String precipitacao;

    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    @Override
    public String toString() {
        return "Dados climaticos(Ano: " + this.ano + ", Mês: " + this.mes + ", Temperatura: " + this.temperatura + ", Precipitação: " + this.precipitacao + ")";
    }
    //reescrevemos toString para exibir um objeeto completo da classe 
    @Override
    public boolean equals(Object obj) {
        Clima c = (Clima) obj;
        return (this.ano.equals(c.ano) && this.mes.equals(c.mes));
        //estamos dizendo quem são as chaves primárias (aquelas que não podem se repetir)
        //reescrevemos o metodo equals para definir os atributos identificadores
    }

    
    
}
```
### Principal 02 Java
```
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Clima> lista = new ArrayList<>();
        String nomeBase = "base.csv";

        // O try-with-resources já fecha o arquivo automaticamente (igual ao 'with' do Python)
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(nomeBase, StandardCharsets.UTF_8))) {
            
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dadosLinha = linha.split(",");
                
                Clima objClima = new Clima(dadosLinha[0],dadosLinha[1],dadosLinha[2], dadosLinha[3]);

                // Requer que o método equals() esteja implementado na classe Clima
                if (!lista.contains(objClima)) {
                    lista.add(objClima);
                }
            }

            for (Clima item : lista) {
                System.out.println(item);
            }

        } catch (Exception e) {
            System.err.println("Ocorreu algum erro... " + e.getMessage());
        }
    }
}
```
