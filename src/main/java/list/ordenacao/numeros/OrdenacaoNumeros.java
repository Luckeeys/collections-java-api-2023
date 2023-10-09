package main.java.list.ordenacao.numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numerosList;

    public OrdenacaoNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numerosList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> listaCrescente = new ArrayList<>(numerosList);
        if ( !numerosList.isEmpty() ) {
            Collections.sort(listaCrescente);
            return listaCrescente;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> listaDecrescente = new ArrayList<>(numerosList);
        if ( !numerosList.isEmpty() ) {
            listaDecrescente.sort(Collections.reverseOrder());
            return listaDecrescente;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(2);
        ordenacaoNumeros.adicionarNumero(8);
        ordenacaoNumeros.adicionarNumero(5);
        ordenacaoNumeros.adicionarNumero(4);

        System.out.println("Sem ordenação   "+ordenacaoNumeros.numerosList);
        System.out.println("Crescente       "+ordenacaoNumeros.ordenarAscendente());
        System.out.println("Decrescente     "+ordenacaoNumeros.ordenarDescendente());
    }
}
