package model;

import db.Base;

import java.util.ArrayList;

public class Tarefa {
    int id;
    String nome;
    String descricao;
    String DataTermino;
    int prioridade;
    String categoria;
    int status;

    private static final String[] STATUSES = { "ToDo", "Doing", "Done" };
    private static final int[] PRIORIDADES = { 1, 2, 3, 4, 5 };

    public Tarefa(){
    }

    public Tarefa(String nome, String descricao, String DataTermino, int prioridade, String categoria, int status) {
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

    public String getDataTermino() {
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

    public void setDataTermino(String dataTermino) {
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

    public static ArrayList<String> categorias(){
        ArrayList<String> categorias = new ArrayList<>();
        for (Tarefa tarefa : Base.listaTarefas()){
            if (!categorias.contains(tarefa.categoria)){
                categorias.add(tarefa.categoria);
            }
        }

        return categorias;
    }

    public static int[] prioridades(){
        return PRIORIDADES;
    }

    public void salvar(){
        Base.criarTarefa(this);
    }
}
