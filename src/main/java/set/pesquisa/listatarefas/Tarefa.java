package main.java.set.pesquisa.listatarefas;

import java.util.Objects;

public class Tarefa {
    //atributos

    private String descricao;
    private boolean status;

    public Tarefa(String descricao, boolean status) {
        this.descricao = descricao;
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescricao());
    }

    @Override
    public String toString() {
        return "{" + descricao + ", " +  status + '}';
    }
}
