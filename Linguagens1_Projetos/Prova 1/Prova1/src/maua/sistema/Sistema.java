package maua.sistema;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import maua.interfaces.autentica;

public class Sistema implements autentica{
    //ArrayList<Usuario> usuarios;
    //ArrayList<Pedido> pedidos;

    public void run() {
        if (autentica()){
            int opt = 1;
            Scanner scanner = new Scanner(System.in);
            while(opt != 0){
                System.out.println("=========== PIZZARIA O RATO QUE RI ===========");
                System.out.println("1 - Nova venda");
                System.out.println("2 - Verificar pedidos");
                System.out.println("3 - Alterar pedidos");
                System.out.println("0 - Sair");
                System.out.print("Insira a opção: ");
                opt = Integer.parseInt(scanner.nextLine());
                switch(opt){
                    case 1:
                        break;
                    case 2:
                        // for (Pedido item : pedidos) {
                            
                        // }
                        break;
                }
            }
        }
    }

    @Override
    public boolean autentica() {
        boolean autenticado = false;
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        while(!autenticado){
            System.out.println("******AUTENTICAÇÃO******");
            System.out.print("Insira o Login: ");
            String login = scanner.nextLine();
            String senha = new String(console.readPassword("Insira a Senha: "));
            
            if(login.equals("teste") && senha.equals("123456")){
                autenticado = true;
                return true;
            } else {
                
                autenticado = false;
                System.out.println("\u001b[41m ERRO: Login e/ou senha incorretos! \u001b[0m");
            }
        }
        return false;
    }
}