import view.Tela;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input;
        int opcao;

        mensagemBoasVindas();
        do {
            mensagemFuncionalidades();
            mensagemOpcao();
            input = new Scanner(System.in);
            opcao = input.nextInt();
        } while (routeFuncionalides(opcao));
    }

    private static void mensagemBoasVindas(){
        System.out.println(" ___________________________________________________ ");
        System.out.println("|                  SEJA BEM VINDO                   |");
        System.out.println("|                        AO                         |");
        System.out.println("|                    TO DO LIST                     |");
        System.out.println("|___________________________________________________|");
    }

    private static void mensagemFuncionalidades(){
        System.out.println("|(1) - Criar uma tarefa                             |");
        System.out.println("|(2) - Ver uma tarefa                               |");
        System.out.println("|(3) - Apagar uma tarefa                            |");
        System.out.println("|(4) - Listar tarefas por Categoria                 |");
        System.out.println("|(5) - Listar tarefas por Prioridade                |");
        System.out.println("|(6) - Listar tarefas por Status                    |");
        System.out.println("|(0) - Para sair                                    |");
        System.out.println("|___________________________________________________|");
    }

    private static void mensagemOpcao(){
        System.out.println("- Digite o número de uma das opções a cima:");
    }

    private static boolean routeFuncionalides(int opcao) {
        switch (opcao) {
            case 1:
                Tela.criarTarefa();
                return true;
            case 2:
                Tela.verTarefa();
                return true;
            case 3:
                Tela.apagarTarefa();
                return true;
            case 4:
                Tela.listarTarefasCategoria();
                return true;
            case 5:
                Tela.listarTarefasPrioridade();
                return true;
            case 6:
                Tela.listarTarefasStatus();
                return true;
            case 0:
                return false;
            default:
                System.out.println("erro: O número escolhido não está entre as opções.");

            return true;
        }
    }
}
