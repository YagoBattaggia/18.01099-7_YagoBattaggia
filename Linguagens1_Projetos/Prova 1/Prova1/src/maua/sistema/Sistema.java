package maua.sistema;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import maua.interfaces.autenticaUsuarios;
import maua.models.Pedido;
import maua.models.Usuario;
import maua.Enums.formaPagamento;

public class Sistema implements autenticaUsuarios{
    ArrayList<Usuario> usuarios;
    ArrayList<Pedido> pedidos;

    public void run() {
        usuarios = new ArrayList<Usuario>();
        pedidos = new ArrayList<Pedido>();
        usuarios.add(new Usuario("teste", "teste@teste.com", "123456"));
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
                        System.out.print("Descrição do pedido: ");
                        String descricao = scanner.nextLine();
                        //Devo aceitar com , tbm? (Criar função para alterar a , para .);
                        System.out.print("Valor do pedido (xxx.xx): ");
                        float valor = Float.parseFloat(scanner.nextLine());
                        System.out.println("0 - Dinheiro");
                        System.out.println("1 - Debito");
                        System.out.println("2 - Credito");
                        System.out.println("3 - Vale Alimentação");
                        System.out.println("4 - Vale Refeição");
                        int indexPagamento = Integer.parseInt(scanner.nextLine());
                        pedidos.add(new Pedido(descricao, valor, formaPagamento.values()[indexPagamento]));
                        break;
                    case 2:
                        for (Pedido item : pedidos) {
                            item.printarPedido();
                        }
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
            for (Usuario user : usuarios) {
                if(login.equals(user.getNome()) && user.checaSenha(senha)){
                    autenticado = true;
                    return true;
                } else {
                    autenticado = false;
                    System.out.println("\u001b[41m ERRO: Login e/ou senha incorretos! \u001b[0m");
                }
            }
        }
        return false;
    }
}