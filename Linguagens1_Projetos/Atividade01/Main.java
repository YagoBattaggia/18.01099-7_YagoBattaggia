//Yago Garcia Battaggia  18.01099-7
public class Main{

    public static void main(String[] args) {
        String hashTransferencia1, hashTransferencia2;
        System.out.println("Estado Inicial:\n");
        Usuarios user1 = new Usuarios("Yago", "123", "teste@teste.com");
        Contas conta1 = new Contas(1000,user1);
        System.out.println("Nome Usuário: " + conta1.getTitular().getNome() + " - Saldo: " + Double.toString(conta1.getSaldo()));
        Usuarios user2 = new Usuarios("Felipe", "123", "teste@teste.com");
        Contas conta2 = new Contas(250,user2);
        System.out.println("Nome Usuário: " + conta2.getTitular().getNome() + " - Saldo: " + Double.toString(conta2.getSaldo()));
        Usuarios user3 = new Usuarios("Felipe", "123", "teste@teste.com");
        Contas conta3 = new Contas(3000,user3);
        System.out.println("Nome Usuário: " + conta3.getTitular().getNome() + " - Saldo: " + Double.toString(conta3.getSaldo()));
        
        
        hashTransferencia1 = Transacao.gerarPagamento(conta1, 250.00);
        Transacao.pagarConta(conta2, conta1, hashTransferencia1);
        Transacao.pagarConta(conta3, conta1, hashTransferencia1);
        Transacao.pagarConta(conta2, conta1, hashTransferencia1);
        hashTransferencia2 = Transacao.gerarPagamento(conta2, 1000.00);
        Transacao.pagarConta(conta3, conta2, hashTransferencia2);
        
        
        System.out.println("Estado Final:\n");
        System.out.println("Nome Usuário: " + conta1.getTitular().getNome() + " - Saldo: " + Double.toString(conta1.getSaldo()));
        System.out.println("Nome Usuário: " + conta2.getTitular().getNome() + " - Saldo: " + Double.toString(conta2.getSaldo()));
        System.out.println("Nome Usuário: " + conta3.getTitular().getNome() + " - Saldo: " + Double.toString(conta3.getSaldo()));
    }
}