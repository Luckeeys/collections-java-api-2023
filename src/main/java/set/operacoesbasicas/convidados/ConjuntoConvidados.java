package main.java.set.operacoesbasicas.convidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add( new Convidado(nome, codigoConvite) );
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        if ( !convidadoSet.isEmpty() ){
            for ( Convidado c : convidadoSet ) {
                if ( c.getCodigo() == codigoConvite ) {
                    convidadoParaRemover = c;
                    break;
                }
            }
            convidadoSet.remove(convidadoParaRemover);
        } else {
            throw new RuntimeException("Set de convidados vazio");
        }
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public Set<Convidado> exibirConvidados() {
        return convidadoSet;
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Convidado 1", 1);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 2);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 2);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 4);

        conjuntoConvidados.removerConvidadoPorCodigoConvite(0);

        System.out.println(conjuntoConvidados.contarConvidados());
        System.out.println(conjuntoConvidados.exibirConvidados());
    }
}
