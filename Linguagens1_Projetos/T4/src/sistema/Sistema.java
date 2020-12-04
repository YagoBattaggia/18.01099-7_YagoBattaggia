package sistema;

import java.io.IOException;
import java.util.Scanner;

public class Sistema {

    public void run() throws IOException, InterruptedException {
        boolean alive = true;
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            menu();
            while(true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor inserir um numero valido: ");

                }
            }
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (alive);
    }

    /**
     * Mostra um menu de opcoes para a tela inicial
     */
    private void menu() {
        System.out.println("Qual ação deseja realizar?");
        System.out.println("1 - Criar um novo personagem.");
        System.out.println("2 - Alterar um personagem existente.");
        System.out.println("3 - Consultar os personagens existentes.");
        System.out.println("4 - Deletar algum personagem.");
        System.out.println("0 - Sair do programa.");
    }
}
