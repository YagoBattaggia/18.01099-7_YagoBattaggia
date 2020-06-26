package maua.sistema;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import maua.interfaces.autenticaUsuarios;
import maua.models.Pedido;
import maua.models.Usuario;
import maua.Enums.formaPagamento;
import maua.Enums.statusPedido;

public class Sistema implements autenticaUsuarios{
    ArrayList<Usuario> usuarios;
    ArrayList<Pedido> pedidos;

    /**
     * Função responsável por rodar o sistema.
     * <p> Essa função printa o menu e gerencia as opções de escolha</p>
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
    */
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
                try{
                    opt = Integer.parseInt(scanner.nextLine());
                    switch(opt){
                        case 1:
                        // Nova venda
                        if(autentica()){
                            System.out.print("Descrição do pedido: ");
                            String descricao = scanner.nextLine();
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
                        }
                        case 2:
                            // Verificar pedidos.
                            for (Pedido item : pedidos) {
                                item.printarPedido();
                            }
                            break;
                        case 3:
                            // Atualizar pedido.
                            if(autentica()){
                                for (Pedido item : pedidos) {
                                    item.printarPedido();
                                }
                                System.out.print("Qual o código do pedido que deseja atualizar? ");
                                String produtoParaAtualizar = scanner.nextLine();
                                System.out.println("0 - Realizado");
                                System.out.println("1 - Preparação");
                                System.out.println("2 - Saiu para entrega");
                                System.out.println("3 - Entregue");
                                System.out.println("4 - Devolvido");
                                System.out.print("Para qual status o pedido deve ser atualizado? ");
                                int novoStatus = Integer.parseInt(scanner.nextLine());
                                // For para printar cada pedido cadastrado no Array de pedidos.
                                for (Pedido item : pedidos) {
                                    if(item.getId().equals(produtoParaAtualizar)){
                                        item.setStatus(statusPedido.values()[novoStatus]);
                                    }
                                }
                            }
                            break;
                        case 0:
                            System.out.println("\u001b[42mFinalizando sistema...\u001b[0m");
                            break;
                        default:
                            System.out.println("\u001b[41mOpção Inválida! Insira uma opção válida!\u001b[0m");
                            break;
                    }
                } catch(NumberFormatException e){
                    System.out.println("\u001b[41mOpção Inválida! Insira uma opção válida!\u001b[0m");
                } catch(IndexOutOfBoundsException i){
                    System.out.println("\u001b[41mOpção Inválida! Insira uma opção válida!\u001b[0m");
                }
                
            }
        }
    }
     /**
     * Função responsável pela autenticação do usuário.
     * <p> Essa função solicita o usuário e senha e checa se os dois estão cadastrados no sistema.</p>
     * @return Retorna TRUE caso quando a senha estiver correta.
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
    */
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