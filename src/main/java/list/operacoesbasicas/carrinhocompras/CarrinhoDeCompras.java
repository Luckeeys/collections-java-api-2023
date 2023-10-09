package main.java.list.operacoesbasicas.carrinhocompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> comprasList;

    public CarrinhoDeCompras() {
        this.comprasList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        comprasList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        for ( Item i : comprasList ) {
            if (i.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(i);
            }
        }
        comprasList.removeAll(itensParaRemover);
    }

    public void calcularValorTotal() {
        double total = 0;
        for (Item c : comprasList) {
            total += c.getPreco() * c.getQuantidade();
        }

        System.out.println("Preço total: " + total);
    }

    public void exibirItens(){
        System.out.println(comprasList);
    }


    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoCompras = new CarrinhoDeCompras();

        carrinhoCompras.adicionarItem("Tablet", 1000.5, 2);
        carrinhoCompras.adicionarItem("Celular", 1400.7, 1);
        carrinhoCompras.calcularValorTotal();
        carrinhoCompras.exibirItens();
    }
}
