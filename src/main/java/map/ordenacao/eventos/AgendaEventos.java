package main.java.map.ordenacao.eventos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    public Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        agendaEventosMap.put( data, new Evento(nome, atracao) );
    }

    public Map<LocalDate, Evento> exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        return eventosTreeMap;
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosOrdenados = exibirAgenda();
        for( Map.Entry<LocalDate, Evento> entry : eventosOrdenados.entrySet() ) {
            if ( entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual) ) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O proximo evento: " + proximoEvento + " será no dia: " + proximaData);
                break;
            }
        }

    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2023, 7, 13), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 8, 14), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 9, 15), "Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 10, 16), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 11, 17), "Evento 5", "Atração 5");

        System.out.println(agendaEventos.exibirAgenda());

        agendaEventos.obterProximoEvento();
    }

}
