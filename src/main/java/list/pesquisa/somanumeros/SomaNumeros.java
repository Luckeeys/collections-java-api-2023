package main.java.list.pesquisa.somanumeros;

import java.util.ArrayList;
import java.util.List;


public class SomaNumeros {
    private List<Integer> numerosList;

    public SomaNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numerosList.add(numero);
    }

    public int calcularSoma() {
        if ( !numerosList.isEmpty() ) {
            int total = 0;
            for ( Integer num : numerosList ) {
                total += num;
            }
            return total;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public int encontrarMaiorNumero() {
        if ( !numerosList.isEmpty() ) {
            int maiorNumero = 0;

            for ( Integer num : numerosList ) {
                if ( maiorNumero == 0 ) {
                    maiorNumero = num;
                } else if ( maiorNumero < num ) {
                    maiorNumero = num;
                }
            }
            return maiorNumero;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public int encontrarMenorNumero() {
        if ( numerosList.isEmpty() ) {
            int menorNumero = 0;

            for ( Integer num : numerosList) {
                if ( menorNumero == 0 ) {
                    menorNumero = num;
                } else if ( menorNumero >= num ) {
                    menorNumero = num;
                }
            }

            return menorNumero;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirNumeros() {
        if ( numerosList.isEmpty() ) {
            System.out.println(numerosList);
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

//        somaNumeros.adicionarNumero(5);
//        somaNumeros.adicionarNumero(10);
//        somaNumeros.adicionarNumero(12);
//        somaNumeros.adicionarNumero(4);
        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.encontrarMaiorNumero());
        System.out.println(somaNumeros.encontrarMenorNumero());
        somaNumeros.exibirNumeros();
    }
}
