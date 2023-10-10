package main.java.map.pesquisa.estoque;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put( cod, new Produto(nome, quantidade, preco) );
    }

    public Map<Long, Produto> exibirProdutos() {
        return estoqueProdutosMap;
    }

    public double calcularValorTotalEstoque() {
        if ( !estoqueProdutosMap.isEmpty() ) {
            double valorTotalEstoque = 0;
            for ( Produto p : estoqueProdutosMap.values() ) {
                valorTotalEstoque += p.getPreco() * p.getQuantidade();
            }
            return valorTotalEstoque;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public String obterProdutoMaisCaro() {
        if ( !estoqueProdutosMap.isEmpty() ) {
            double produtoMaisCaro = Double.MIN_VALUE;
            String nomeProdutoMaisCaro = null;
            for ( Produto p : estoqueProdutosMap.values() ) {
                if ( p.getPreco() > produtoMaisCaro ) {
                    produtoMaisCaro = p.getPreco();
                    nomeProdutoMaisCaro = p.getNome();
                }
            }
            return nomeProdutoMaisCaro;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public String obterProdutoMaisBarato() {
        if ( !estoqueProdutosMap.isEmpty() ) {
            double produtoMaisBarato = Double.MAX_VALUE;
            String nomeProdutoMaisBarato = null;
            for ( Produto p : estoqueProdutosMap.values() ) {
                if ( p.getPreco() < produtoMaisBarato ) {
                    produtoMaisBarato = p.getPreco();
                    nomeProdutoMaisBarato = p.getNome();
                }
            }
            return nomeProdutoMaisBarato;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }

    public String obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        if ( !estoqueProdutosMap.isEmpty() ) {
            double produtoMaiorValor = Double.MIN_VALUE;
            String nomeProdutoMaiorValor = null;
            for ( Produto p : estoqueProdutosMap.values() ) {
                if ( produtoMaiorValor < (p.getPreco() * p.getQuantidade()) ) {
                    produtoMaiorValor = p.getPreco() * p.getQuantidade();
                    nomeProdutoMaiorValor = p.getNome();
                }
            }
            return nomeProdutoMaiorValor;
        } else {
            throw new RuntimeException("Map está vazio");
        }
    }



    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Lapis", 10, 1.5);
        estoqueProdutos.adicionarProduto(2L, "Caneta", 5, 2);
        estoqueProdutos.adicionarProduto(3L, "Borracha", 3, 1.2);
        estoqueProdutos.adicionarProduto(4L, "apontador", 2, 1.1);

        System.out.println("Produtos em estoque "+estoqueProdutos.exibirProdutos());

        System.out.println("O valor total do estoque é R$ "+estoqueProdutos.calcularValorTotalEstoque());
        System.out.println("O produto mais caro é: "+estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("O produto mais barato é: "+estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("O produto com maior montante é: "+estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
