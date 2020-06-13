package maua.models;

import java.util.Random;
import maua.Enums.formaPagamento;

public class Pedido {
    private String id;
    private String descricao;
    private float valor;
    private Enum<formaPagamento> formaPagamento;

    public Pedido(String descricao, float valor, Enum<formaPagamento> formaPagamento){
        this.descricao = descricao;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.id = geradorId();
    }

    public void printarPedido(){
        System.out.println("=== PEDIDO " + this.id + " ===");
        System.out.println("ID - " + this.id );
        System.out.println("DESCRIÇÃO - " + this.descricao);
        System.out.println("VALOR - R$" + this.valor);
        System.out.println("FORMA DE PAGAMENTO - " + this.formaPagamento);
    }

    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++){
            idGerado += random.nextInt(10);
        }
        return idGerado;
    }
}