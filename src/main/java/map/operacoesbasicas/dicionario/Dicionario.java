package main.java.map.operacoesbasicas.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        System.out.println("Palavra: '" + palavra + "' adicionada com sucesso");
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if ( !dicionarioMap.isEmpty() ) {
            System.out.println("Palavra: '" + palavra + "' removida com sucesso");
            dicionarioMap.remove(palavra);
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public Map<String, String> exibirPalavras() {
        if ( !dicionarioMap.isEmpty() ) {
            return dicionarioMap;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        if ( !dicionarioMap.isEmpty() ) {
            return dicionarioMap.get(palavra);
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Abundante", "Em grande quantidade, mais do que suficiente ou necessário");
        dicionario.adicionarPalavra("Eficaz", "Capaz de produzir o efeito desejado, bem-sucedido, eficiente");
        dicionario.adicionarPalavra("Convergir", "Encontrar um ponto comum, aproximar-se ou encontrar-se em um ponto");
        dicionario.adicionarPalavra("Resiliente", "Capaz de se recuperar rapidamente de adversidades ou dificuldades");
        dicionario.adicionarPalavra("Intrépido", "Destemido, corajoso, que não tem medo diante do perigo");

        System.out.println("Primeira lista: "+dicionario.exibirPalavras());

        dicionario.removerPalavra("Convergir");
        System.out.println("Segunda lista: "+dicionario.exibirPalavras());

        System.out.println("o significado da palavra é: " + dicionario.pesquisarPorPalavra("Resiliente"));
    }
}
