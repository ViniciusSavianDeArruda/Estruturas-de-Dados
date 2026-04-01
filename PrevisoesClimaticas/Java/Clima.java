package Java;
public class Clima{
   public String ano;
   public String mes;
   public String temperatura;
   public String precipitacao;
   
//constructor da classe clima, recebe o ano, mes, temperatura e precipitacao
    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
        
    }
    //rescrevemos o toString para imprimir os dados do clima
    @Override
    public String toString() {
        return "Clima [ano=" + this.ano + ", mes=" + this.mes + ", temperatura=" + this.temperatura + ", precipitacao=" + this.precipitacao + "]";
    }

        // rescrevemos o equals para definir os atributis identificadoes
    @Override
    public boolean equals(Object obj) {
        Clima c = (Clima) obj;
        return (this.ano.equals(c.ano) && this.mes.equals(c.mes));
    }

    

    
}