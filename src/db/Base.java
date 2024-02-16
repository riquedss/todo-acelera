package db;
import model.*;
import java.util.ArrayList;

public class Base {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();

    public static ArrayList<Tarefa> tarefasLista() {
        return tarefas;
    }

    public static void criarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public static Tarefa getTarefaById(int id){
        for (Tarefa tarefa : tarefas){
            if(tarefa.getId() == id){
                return tarefa;
            }
        }

        return null;
    }

    public static boolean alterarTarefa(int id, Tarefa tarefa){
        for (int i = 0; i < tarefas.size(); i++){
            if(tarefas.get(i).getId() == id){
                tarefas.set(i, tarefa);
                return true;
            }
        }

        return false;
    }

    public static boolean deleteLista(int id){
        Tarefa tarefa = getTarefaById(id);
        if (tarefa != null){
            tarefas.remove(tarefa);
            return true;
        }

        return false;
    }
}
