import java.util.ArrayList;
public class Splitar {
    public static void main(String[] args) {
        ArrayList<Glicemia> lista = new ArrayList<>();
        //ler linha
        String linha = "120;11/03/2026;9:00"; 
        //splitar linha
        String[] vetorLinhas = linha.split(";");
        //criar objeto glicemia
        Glicemia obj = new Glicemia(Integer.parseInt(vetorLinhas[0]), vetorLinhas[1], vetorLinhas[2]);
        //adicionar na lista
        if(!lista.contains(obj)){
            lista.add(obj);
        }
        //exibir lista
        for(Glicemia g : lista){
            System.out.println(g.valor + " - " + g.data + " - " + g.hora);
        }

    }
}
