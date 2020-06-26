package maua.models;

import java.util.Random;
import maua.Enums.formaPagamento;
import maua.Enums.statusPedido;

/**
 * Classe para gerenciar e modelar o pedido do sistema 
 * @author Yago Garcia Battaggia - 18.01099-7@maua.br
 * @since 12/06/2020
 * @version 1.0
 */
public class Pedido {
    private String id;
    private String descricao;
    private float valor;
    private Enum<formaPagamento> formaPagamento;
    private Enum<statusPedido> statusDoPedido;

    /**
     * Construtor da classe Pedido
     * @param descrição - Descrição do pedido a ser criado
     * @param valor - Valor do pedido
     * @param formaPagamento - Enum<formaPagamento> da forma de pagamento do pedido
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
     */
    public Pedido(String descricao, float valor, Enum<formaPagamento> formaPagamento){
        this.descricao = descricao;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.id = geradorId();
        this.statusDoPedido = statusPedido.REALIZADO;
    }

    /**
     * Função responsável por printar o pedido.
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
     */
    public void printarPedido(){
        System.out.println("=== PEDIDO " + this.id + " ===");
        System.out.println("ID - " + this.id );
        System.out.println("DESCRIÇÃO - " + this.descricao);
        System.out.println("VALOR - R$" + this.valor);
        System.out.println("FORMA DE PAGAMENTO - " + this.formaPagamento);
        System.out.println("STATUS - " + this.statusDoPedido);
        System.out.println("==================");
    }
        
    /**
     * Gera Id randômico com 3 números
     * @return Retorna uma String com 3 números.
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
     */
    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++){
            idGerado += random.nextInt(10);
        }
        return idGerado;
    }
    /**
     * @return Retorna Id do pedido.
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
     */
    public String getId(){
        return this.id;
    }
    /**
     * Função para alterar o status do pedido
     * @param status - Recebe Enum<statusPedido> contendo o novo status do pedido.
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
     */
    public void setStatus(Enum<statusPedido> status){
        this.statusDoPedido = status;
    }
}