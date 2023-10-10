package main.java.set.pesquisa.listatarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add( new Tarefa(descricao, false) );
    }

    public void removerTarefa(String descricao) {
        if ( !tarefaSet.isEmpty() ) {
            for ( Tarefa t : tarefaSet ) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaSet.remove(t);
                    System.out.println("Tarefa '" + t.getDescricao() + "' removida com sucesso");
                    break;
                }
            }
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public Set<Tarefa> exibirTarefas(){
        if ( !tarefaSet.isEmpty() ) {
            return tarefaSet;
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public int contarTarefas(){
        if ( !tarefaSet.isEmpty() ) {
            return tarefaSet.size();
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        if ( !tarefaSet.isEmpty() ) {
            Set<Tarefa> tarefasConcluidas = new HashSet<>();
            for ( Tarefa t : tarefaSet ) {
                if ( t.isStatus() == true ) {
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public Set<Tarefa> obterTarefasPendentes() {
        if ( !tarefaSet.isEmpty() ) {
            Set<Tarefa> tarefasPendentes = new HashSet<>();
            for ( Tarefa t : tarefaSet ) {
                if ( t.isStatus() == false ) {
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public void marcarTarefaConcluida(String descricao) {
        if ( !tarefaSet.isEmpty() ) {
            for ( Tarefa t : tarefaSet ) {
                if ( t.getDescricao().equalsIgnoreCase(descricao) ) {
                    t.setStatus(true);
                    System.out.println("Tarefa: '" + t.getDescricao() + "' concluída");
                    break;
                }
            }
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        if ( !tarefaSet.isEmpty() ) {
            for ( Tarefa t : tarefaSet ) {
                if ( t.getDescricao().equalsIgnoreCase(descricao) ){
                    t.setStatus(false);
                    System.out.println("Tarefa: '"+t.getDescricao()+"' desmarcada como concluída");
                    break;
                }
            }
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public void limparListaTarefas(){
        if ( !tarefaSet.isEmpty() ) {
            Set<Tarefa> tarefasParaExcluir = new HashSet<>();
            for ( Tarefa t : tarefaSet ) {
                tarefasParaExcluir.add(t);
            }
            tarefaSet.removeAll(tarefasParaExcluir);
            System.out.println("Todas as tarefas foram removidas");
        } else {
            throw new RuntimeException("Set está vazio");
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Iniciar trabalhos");
        listaTarefas.adicionarTarefa("Iniciar trabalhos");
        listaTarefas.adicionarTarefa("Arrumar a mala");
        listaTarefas.adicionarTarefa("Preencher temas");
        listaTarefas.adicionarTarefa("Consultar banco de dados");

        System.out.println(listaTarefas.exibirTarefas());

        listaTarefas.removerTarefa("Iniciar trabalhos");

        System.out.println(listaTarefas.exibirTarefas());

        System.out.println("Numero de tarefas: "+listaTarefas.contarTarefas());

        listaTarefas.marcarTarefaConcluida("Arrumar a mala");
        listaTarefas.marcarTarefaConcluida("Preencher Temas");
        listaTarefas.marcarTarefaPendente("Arrumar a mala");
        System.out.println("Tarefas pendentes: "+listaTarefas.obterTarefasPendentes());
        System.out.println("Tarefas concluidas: "+listaTarefas.obterTarefasConcluidas());

        listaTarefas.limparListaTarefas();
    }
}
