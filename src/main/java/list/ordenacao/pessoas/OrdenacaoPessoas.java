package main.java.list.ordenacao.pessoas;

import main.java.list.ordenacao.pessoas.ComparatorPorAltura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoasList;

    public OrdenacaoPessoas() {
        this.pessoasList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoasList.add( new Pessoa(nome, idade, altura) );
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoasList);
        Collections.sort(pessoaPorIdade);
        return pessoaPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoasList);
        Collections.sort(pessoaPorAltura, new ComparatorPorAltura());
        return pessoaPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();
        ordenacaoPessoas.adicionarPessoa("Nome 1", 20, 1.54);
        ordenacaoPessoas.adicionarPessoa("Nome 2", 22, 1.72);
        ordenacaoPessoas.adicionarPessoa("Nome 3", 21, 1.70);
        ordenacaoPessoas.adicionarPessoa("Nome 4", 19, 1.66);

        System.out.println("por idade:      "+ordenacaoPessoas.ordenarPorIdade());
        System.out.println("por altura:     "+ordenacaoPessoas.ordenarPorAltura());

        System.out.println("sem ordenacao:  "+ordenacaoPessoas.pessoasList);
    }
}
