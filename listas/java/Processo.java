package listas.java;
public class Processo {

    public int id;
    public String descricao;

    public Processo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Processo outro = (Processo) obj;

        return this.id == outro.id;
    }

    @Override
    public String toString() {
        return "Processo{id=" + id + ", descricao='" + descricao + "'}";
    }
}