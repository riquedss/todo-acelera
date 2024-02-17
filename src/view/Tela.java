package view;
import db.Base;
import model.Tarefa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tela {
    public static void criarTarefa() {
        do {
            System.out.println(" ___________________________________________________ ");
            System.out.println("|                     CADASTRO                      |");
            System.out.println("|                     DE TAREFA                     |");
            System.out.println("|___________________________________________________|");

            Tarefa tarefa = formTarefa();

            tarefa.salvar();
            System.out.println("Criada tarefa com sucesso!");
            System.out.println();
        } while (confirmarContinuacaoTela());

        System.out.println(" ___________________________________________________ ");
    }

    public static void verTarefa(){
        Scanner input = new Scanner(System.in);
        Tarefa tarefa;
        int id;
        do {
            System.out.println(" ___________________________________________________ ");
            System.out.println("|                     VER TAREFA                    |");
            System.out.println("|___________________________________________________|");

            System.out.print("id:");
            id = input.nextInt();

            tarefa = Base.getTarefaById(id);
            if (tarefa != null){
                mostrarTarefa(tarefa);
            } else {
                System.out.println("Tarefa não encontrada!");
            }
        } while (confirmarContinuacaoTela());
    }

    public static void apagarTarefa(){
        Scanner input = new Scanner(System.in);
        int id;
        do {
            System.out.println(" ___________________________________________________ ");
            System.out.println("|                  APAGAR TAREFA                    |");
            System.out.println("|___________________________________________________|");

            System.out.print("id:");
            id = input.nextInt();

            if (Base.deleteLista(id)){
                System.out.println("Tarefa deletada com sucesso!");
            } else {
                System.out.println("Tarefa não encontrada!");
            }
        } while (confirmarContinuacaoTela());
    }

    public static void listarTarefasCategoria(){
        do {
            System.out.println(" ___________________________________________________ ");
            System.out.println("|              TAREFA POR CATEGORIA                 |");
            System.out.println("|___________________________________________________|");

            for (String categoria : Tarefa.categorias()){
                System.out.println("|CATEGORIA: " + categoria);
                System.out.println("|___________________________________________________|");
                for (Tarefa tarefa : Base.listaTarefas()){
                    if(tarefa.getCategoria().equals(categoria)){
                        mostrarTarefa(tarefa);
                    }
                }
            }
        } while (confirmarContinuacaoTela());
    }

    public static void listarTarefasPrioridade(){
        do {
            System.out.println(" ___________________________________________________ ");
            System.out.println("|              TAREFA POR CATEGORIA                 |");
            System.out.println("|___________________________________________________|");

            for (int prioridade : Tarefa.prioridades()){
                System.out.println("|PRIORIDADE " + prioridade);
                System.out.println("|___________________________________________________|");
                for (Tarefa tarefa : Base.listaTarefas()){
                    if(tarefa.getPrioridade() == prioridade){
                        mostrarTarefa(tarefa);
                    }
                }
            }
        } while (confirmarContinuacaoTela());
    }

    public static void listarTarefasStatus(){
        do {
            System.out.println(" ___________________________________________________ ");
            System.out.println("|                TAREFA POR STATUS                  |");
            System.out.println("|___________________________________________________|");

            for (String status : Tarefa.Statuses()){
                System.out.println("|STATUS: " + status);
                System.out.println("|___________________________________________________|");
                for (Tarefa tarefa : Base.listaTarefas()){
                    mostrarTarefa(tarefa);
                }
            }
        } while (confirmarContinuacaoTela());

    }

    private static Tarefa formTarefa(){
        String nome;
        String descricao;
        String dataTermino;
        int prioridade;
        String categoria;
        int status;
        Tarefa tarefa;

        Scanner input = new Scanner(System.in);
        System.out.print("Nome:");
        nome = input.nextLine();
        System.out.print("Descrição:");
        descricao = input.nextLine();
        System.out.print("Data de Término | formato: 01-10-2010:");
        dataTermino = input.nextLine();
        System.out.print("Categoria:");
        categoria = input.nextLine();
        System.out.print("Prioridade (1-5):");
        prioridade = input.nextInt();
        System.out.print("Status  (0 - Todo | 1 - Doing | 2 - Done):");
        status = input.nextInt();

        return new Tarefa(nome, descricao, dataTermino, prioridade, categoria, status);
    }

    private static boolean confirmarContinuacaoTela(){
        Scanner input = new Scanner(System.in);
        System.out.print("Deseja continua? (s/*)");
        String opcao = input.nextLine();

        limparTerminal();
        return opcao.equalsIgnoreCase("s");
    }

    private static void mostrarTarefa(Tarefa tarefa){
        System.out.println("|Id:" + tarefa.getId());
        System.out.println("|Nome:" + tarefa.getNome());
        System.out.println("|Descrição:" + tarefa.getDescricao());
        System.out.println("|Data término:" + tarefa.getDataTermino());
        System.out.println("|Prioridade:" + tarefa.getPrioridade());
        System.out.println("|Categoria:" + tarefa.getCategoria());
        System.out.println("|Status:" + tarefa.getStatus());
        System.out.println("|___________________________________________________|");
    }

    private static void limparTerminal(){
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("bash", "-c", "clear");
            Process processo = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
