package atividade.sistema;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import atividade.interfaces.*;
import atividade.models.*;
import atividade.members.*;
/**
 * Classe para rodar o sistema
 *      Essa classe é responsável por iniciar e gerenciar o sistema do MAsK_S0c13ty
 * @author Yago Garcia Battaggia - 18.01099-7@maua.br
 * @author Guilherme Ballardini - 18.01353-8@maua.br
 * @version 1.0
 */
public class Sistema {
    private static List<Membro> equipe;
    private static String jornada;

    public Sistema(){
        jornada = "Regular";
    }

    public static void run(){
        menu();
    }

    



    private static void exibeMembrosCadastrados() {
        System.out.println("Lista de membros cadastrados:");
        
    }

    static private void menu(){
        boolean sistema = true;
        while(sistema){
            equipe = new ArrayList<Membro>();
            System.out.println("TOTAL" + equipe.size());
            System.out.println("BEM VINDO AO SISTEMA DO MAsK_S0c13ty");
            System.out.println("Escolha a opcao desejada:");
            System.out.println("0 - Sair do sistema");
            System.out.println("1 - Cadastrar novo membro");
            System.out.println("2 - Apresentação dos novos membros");
            System.out.println("3 - Deixar um colaborador ir");
            System.out.println("4 - Trocar a jornada de trabalho");
            System.out.println("5 - Postar mensagem");
            System.out.println("Jornada de Trabalho Atual:" + jornada);
            Scanner scanner = new Scanner(System.in);
            int option = Integer.parseInt(scanner.nextLine());
            if (option == 1){
                System.out.print("INSIRA O NOME: ");
                String nome = scanner.nextLine();
                System.out.print("INSIRA O EMAIL: ");
                String email = scanner.nextLine();
                System.out.println("1 - Mobile Member");
                System.out.println("2 - Heavy Lifter");
                System.out.println("3 - Script Boy");
                System.out.println("4 - Big Brother");
                System.out.print("INSIRA A OPÇÃO: ");
                int funcao = Integer.parseInt(scanner.nextLine());
                    if (funcao == 1){
                        Membro m = new MobileMembers(nome, email);
                        equipe.add(m);
                    } else if (funcao == 2){
                        equipe.add(new HeavyLifters(nome, email));
                    } else if (funcao == 3){
                        equipe.add(new ScriptGuys(nome, email));
                    } else if (funcao == 4){
                        equipe.add(new BigBrothers(nome, email));
                    }
            } else if (option == 2){
                for (Membro membro : equipe) {
                    membro.Apresenta();
                }
            } else if (option == 3){
                
            } else if (option == 4){
                System.out.println(jornada);
                if (jornada == "Regular"){
                    jornada = "Extra";
                } else if(jornada == "Extra"){
                    jornada = "Regular";
                }
            } else if (option == 5){
                for (Membro membro : equipe) {
                    //membro.PostarMensagem();
                }
            } else {
                sistema = false;
            }
        }
    }
}