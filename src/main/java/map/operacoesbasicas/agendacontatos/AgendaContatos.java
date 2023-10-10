package main.java.map.operacoesbasicas.agendacontatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    //atributos
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        agendaContatoMap.remove(nome);
    }

    public Map<String, Integer> exibirContatos() {
        return agendaContatoMap;
    }

    public Integer pesquisarPorNome(String nome) {
        return agendaContatoMap.get(nome);
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Lucas", 1198873);
        agendaContatos.adicionarContato("Lucas", 1194828);
        agendaContatos.adicionarContato("Jhennifer", 1197388);
        agendaContatos.adicionarContato("Gui", 4558873);
        agendaContatos.adicionarContato("Leo", 1597536);

//        agendaContatos.removerContato("Gui");

        System.out.println(agendaContatos.exibirContatos());

        System.out.println(agendaContatos.pesquisarPorNome("Leo"));
    }
}
