package main.java.set.operacoesbasicas.palavrasunicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if ( !palavrasUnicasSet.isEmpty() ) {
            if ( palavrasUnicasSet.contains(palavra) ) {
                palavrasUnicasSet.remove(palavra);
            } else {
                throw new RuntimeException("A palavra não está no Set");
            }
        } else {
            throw new RuntimeException("O Set esta vazio");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return palavrasUnicasSet.contains(palavra);
    }

    public Set<String> exibirPalavrasUnicas() {
        if ( !palavrasUnicasSet.isEmpty() ) {
            return palavrasUnicasSet;
        } else {
            throw new RuntimeException("O Set esta vazio");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Lapis");
        conjuntoPalavrasUnicas.adicionarPalavra("Caneta");
        conjuntoPalavrasUnicas.adicionarPalavra("Caderno");
        conjuntoPalavrasUnicas.adicionarPalavra("Livro");
        conjuntoPalavrasUnicas.adicionarPalavra("Caderno");

        conjuntoPalavrasUnicas.removerPalavra("Lapis");

        System.out.println(conjuntoPalavrasUnicas.exibirPalavrasUnicas());
    }
}
