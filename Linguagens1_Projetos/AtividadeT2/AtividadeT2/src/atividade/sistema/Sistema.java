package atividade.sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import atividade.interfaces.*;
import atividade.models.Membro;

public class Sistema implements PostarMensagem {
    private String jornada;

    public Sistema(){
        this.jornada = "Regular";
    }

    public static void run(){
        System.out.println("BEM VINDO AO SISTEMA DO MAsK_S0c13ty");
        
        menu();
    }

    



    private static void exibeMembrosCadastrados() {
        System.out.println("Lista de membros cadastrados:");
        
    }

    static private void menu(){
        System.out.println("Escolha a opcao desejada:");
        System.out.println("0 - Sair do sistema");
        System.out.println("1 - Cadastrar novo membro");
        System.out.println("2 - Apresentação dos novos membros");
        System.out.println("3 - Deixar um colaborador ir");
        System.out.println("4 - Trocar a jornada de trabalho");
        System.out.println("5 - Postar mensagem");
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        if (option == 1){
            List<Membro> Equipe = new ArrayList<>();
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
            Membro membroAux = new Membro(nome, email, funcao);
            Equipe.add(membroAux);
        } else if (option == 2){
            
        } else if (option == 4){
            
        } else if (option == 5){
            
        } else {

        }
    }
}