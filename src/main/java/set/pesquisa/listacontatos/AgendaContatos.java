package main.java.set.pesquisa.listacontatos;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatosSet;

    public AgendaContatos() {
        this.contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, String numero) {
        contatosSet.add( new Contato(nome, numero) );
    }

    public Set<Contato> exibirContatos() {
        return contatosSet;
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> nomePesquisado = new HashSet<>();
        for ( Contato c : contatosSet ) {
            if ( c.getNome().startsWith(nome) ) {
                nomePesquisado.add(c);
            }
        }
        return nomePesquisado;
    }

    public Contato atualizarNumeroContato(String nome, String novoNumero) {
        Contato contatoAtualizado = null;
        for ( Contato c : contatosSet ) {
            if ( c.getNome().equalsIgnoreCase(nome) ) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }

        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        System.out.println("Agenda antes de adicionar: " +agendaContatos.exibirContatos());

        agendaContatos.adicionarContato("Lucas", "1111");
        agendaContatos.adicionarContato("Lucas", "7777");
        agendaContatos.adicionarContato("Lucas Sacramento", "2222");
        agendaContatos.adicionarContato("Lucas Cipriano", "3333");
        agendaContatos.adicionarContato("Ana", "4444");

        System.out.println("Agenda depois de adicionar: " + agendaContatos.exibirContatos());

//        System.out.println(agendaContatos.pesquisarPorNome("Lucas"));

        System.out.println("O numero de Contato " + agendaContatos.atualizarNumeroContato("Lucas Cipriano", "5555").getNome() +
                " foi atualizado para: " + agendaContatos.atualizarNumeroContato("Lucas Cipriano", "5555").getNumero());

        System.out.println("Agenda depois de atualizar: " + agendaContatos.exibirContatos());
    }
}
