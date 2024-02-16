package model;
import java.time.LocalDate;

public class Tarefa {
    int id;
    String nome;
    String descricao;
    LocalDate DataTermino;
    int prioridade;
    String categoria;
    int status;

    static final String[] STATUSES = { "ToDo", "Doing", "Done" };

    public Tarefa(){
    }

    public Tarefa(String nome, String descricao, LocalDate DataTermino, int prioridade, String categoria, int status) {
        this.nome = nome;
        this.descricao = descricao;
        this.DataTermino = DataTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataTermino() {
        return DataTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataTermino(LocalDate dataTermino) {
        DataTermino = dataTermino;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static String[] Statuses(){
        return STATUSES;
    }
}
