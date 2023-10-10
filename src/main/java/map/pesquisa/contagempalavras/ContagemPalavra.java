package main.java.map.pesquisa.contagempalavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavra {
    private Map<String, Integer> contagemPalavraMap;

    public ContagemPalavra() {
        this.contagemPalavraMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemPalavraMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        contagemPalavraMap.remove(palavra);
    }

    public String exibirContagemPalavras() {
        String palavrasContagem = "";
        for ( Map.Entry<String, Integer> entry: contagemPalavraMap.entrySet() ) {
            palavrasContagem += entry + "\n";
        }
        return palavrasContagem;
    }

    public String encontrarPalavraMaisFrequente() {
        String linguagemMaisFrequente = null;
        int maiorContagem = 0;
        for ( Map.Entry<String, Integer> entry: contagemPalavraMap.entrySet() ) {
            if ( entry.getValue() > maiorContagem ) {
                maiorContagem = entry.getValue();
                linguagemMaisFrequente = entry.getKey();
            }
        }
        return linguagemMaisFrequente + "=" + maiorContagem;
    }

    public static void main(String[] args) {
        ContagemPalavra contagemPalavra = new ContagemPalavra();

        contagemPalavra.adicionarPalavra("Abundante", 8);
        contagemPalavra.adicionarPalavra("Eficaz", 6);
        contagemPalavra.adicionarPalavra("Convergir", 4);
        contagemPalavra.adicionarPalavra("Resiliente", 2);

        System.out.println("lista palavras "+contagemPalavra.exibirContagemPalavras());
        System.out.println("Palavra mais frequente e repetições: "+contagemPalavra.encontrarPalavraMaisFrequente());
    }
}
