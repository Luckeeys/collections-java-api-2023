package main.java.set.ordenacao.listaalunos;

import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new TreeSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double nota1, double nota2) {
        alunoSet.add( new Aluno(nome, matricula, nota1, nota2, (nota1 + nota2) / 2) );
    }

    public void removerAluno(long matricula) {
        if ( !alunoSet.isEmpty() ) {
            for ( Aluno a : alunoSet ) {
                if ( a.getMatricula() == matricula ) {
                    alunoSet.remove(a);
                    System.out.println("Aluno: '" +a.getNome()+ "' foi removido com sucesso");
                    break;
                }
            }
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        if ( !alunoSet.isEmpty() ) {
            return alunoSet;
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public Set<Aluno> exibirAlunosPorNota() {
        if ( !alunoSet.isEmpty() ) {
            Set<Aluno> alunoPorNota = new TreeSet<>(new ComparatorPorNota());
            alunoPorNota.addAll(alunoSet);
            return alunoPorNota;
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Xavier", 1L, 2, 1);
        gerenciadorAlunos.adicionarAluno("Leo", 2L, 8, 9);
        gerenciadorAlunos.adicionarAluno("Gui", 3L, 5, 6);
        gerenciadorAlunos.adicionarAluno("Jhenni", 4L, 5, 9);
        gerenciadorAlunos.adicionarAluno("Wesllei", 5L, 7, 3);
        gerenciadorAlunos.adicionarAluno("Lucas", 6L, 7, 8);

        gerenciadorAlunos.removerAluno(3L);

        System.out.println("Aluno por nome: "+gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println("Aluno por nota: "+gerenciadorAlunos.exibirAlunosPorNota());
    }
}
