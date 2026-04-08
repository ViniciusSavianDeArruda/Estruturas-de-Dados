package listas.java;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class ExemploAluno {
    String cpf;
    String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ExemploAluno(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        ExemploAluno other = (ExemploAluno) obj; // <<< corrigido

        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Aluno [cpf=" + cpf + ", nome=" + nome + "]";
    }
}

// Classe separada para validação
class Util {
    public static boolean cpfValido(String cpf) {
        return true;
    }
}

public class Aluno {
    public static void main(String[] args) {

        List<ExemploAluno> alunos = new ArrayList<>(); // <<< corrigido
        Scanner teclado = new Scanner(System.in);

        String cpf, nome;
        ExemploAluno alunoTMP; // <<< corrigido

        do {
            do {
                System.out.print("Digite o cpf: ");
                cpf = teclado.nextLine().toUpperCase();

                if (cpf.equals("FIM")) {
                    alunos.sort((a1, a2) -> a1.getNome().compareTo(a2.getNome()));

                    System.out.println("Alunos cadastrados....");
                    for (ExemploAluno a : alunos) { // <<< corrigido
                        System.out.println(a);
                    }

                    System.exit(0);
                }

                if (Util.cpfValido(cpf)) {
                    break;
                } else {
                    System.out.println("CPF invalido!!!");
                }

            } while (true);

            System.out.print("Nome: ");
            nome = teclado.nextLine().toLowerCase();

            alunoTMP = new ExemploAluno(cpf, nome); // <<< corrigido

            if (!alunos.contains(alunoTMP)) {
                alunos.add(alunoTMP);
            } else {
                System.out.println("Aluno com este cpf ja cadastrado!!");
            }

        } while (true);
    }
}
