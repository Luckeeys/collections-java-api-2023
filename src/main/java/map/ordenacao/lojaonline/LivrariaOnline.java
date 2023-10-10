package main.java.map.ordenacao.lojaonline;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LivrariaOnline {
    private Map<String, Livro> livrariaOnlineMap;

    public LivrariaOnline() {
        this.livrariaOnlineMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrariaOnlineMap.put( link, new Livro(titulo, autor, preco) );
    }

    public void removerLivro(String titulo) {
        if ( !livrariaOnlineMap.isEmpty() ) {
            for ( Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet() ) {
                if ( entry.getValue().getTitulo().equalsIgnoreCase(titulo) ) {
                    livrariaOnlineMap.remove(entry.getKey());
                    break;
                };
            }
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        if ( !livrariaOnlineMap.isEmpty() ) {
            Map<String, Livro> listaTreeMap = new TreeMap<>(livrariaOnlineMap);
            return listaTreeMap;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        if ( !livrariaOnlineMap.isEmpty() ) {
            Map<String, Livro> listaLivroPorAutor = new HashMap<>();
            for ( Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet() ) {
                if ( entry.getValue().getAutor().equalsIgnoreCase(autor) ) {
                    listaLivroPorAutor.put(entry.getKey(), entry.getValue());
                }
            }
            return listaLivroPorAutor;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public Livro obterLivroMaisCaro() {
        if ( !livrariaOnlineMap.isEmpty() ) {
            double valorLivroMaisCaro = Double.MIN_VALUE;
            Livro livroMaisCaro = null;
            for ( Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet() ) {
                if ( entry.getValue().getPreco() > valorLivroMaisCaro ) {
                    valorLivroMaisCaro = entry.getValue().getPreco();
                    livroMaisCaro = entry.getValue();
                }
            }
            return livroMaisCaro;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public Livro exibirLivroMaisBarato() {
        if ( !livrariaOnlineMap.isEmpty() ) {
            double valorLivroMaisBarato = Double.MAX_VALUE;
            Livro livroMaisBarato = null;
            for ( Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet() ) {
                if ( entry.getValue().getPreco() < valorLivroMaisBarato ) {
                    valorLivroMaisBarato = entry.getValue().getPreco();
                    livroMaisBarato = entry.getValue();
                }
            }
            return livroMaisBarato;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Imperfeitos-Christina-Lauren/dp/",
                "Imperfeitos", "Christina Lauren", 16.20 );
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Biblioteca-Meia-Noite-Matt-Haig-ebook/dp/",
                "A Biblioteca da Meia-Noite", "Matt Haig", 19.14 );
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Coraline-Acompanha-marcador-páginas-especial/dp/",
                "Coraline", "Neil Gaiman", 23.45 );
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/diário-Anne-Frank/dp/",
                "O diário de Anne Frank", "Anne Frank", 13.99 );

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        livrariaOnline.removerLivro("Imperfeitos");
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Anne Frank"));
        System.out.println(livrariaOnline.obterLivroMaisCaro());
        System.out.println(livrariaOnline.exibirLivroMaisBarato());

    }
}
