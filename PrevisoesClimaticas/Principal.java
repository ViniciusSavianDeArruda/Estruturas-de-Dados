package PrevisoesClimaticas;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Clima> lista = new ArrayList<>();
        //Clima umClima = new Clima("2020", "janeiro,", "Quente", "pouca");
        String linha = "2020,janeiro,Quente,muito";
        String dadosLinha[] = linha.split(",");

        Clima objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);

        if(!lista.contains(objClima)){
            lista.add(objClima);

        }
        linha = "2020, janeiro, frio, pouca";
        dadosLinha = linha.split(",");
        objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);
        if(!lista.contains(objClima)){
            lista.add(objClima);

        }
        for(Clima c: lista){
            System.out.println(c);
        }

    
    }
}
