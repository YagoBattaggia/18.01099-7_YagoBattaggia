package Exemplo01;

public class ContaTesteDrive{
    public static void main(String[] args) {
        // Declara c1, ainda sem nada dentro (nullPointer)
        Conta c1;
        // Instancia Conta - coloca a referencia de um objeto
        c1 = new Conta();
        // Acessa o titular da conta
        c1.cliente.nome = "Yago";
        System.out.println(c1.cliente.nome);
        Conta c2 = new Conta();
        c2.cliente.nome = "Goku";

        System.out.println(c1.cliente.nome);
        System.out.println(c2.cliente.nome);
        c1.saldo = 2000;
        c1.visualizarSaldo();
        c1.sacar(100);
        c1.visualizarSaldo();
        c1.sacar(100);
        c1.visualizarSaldo();

        c1.transferirDinheiro(c2, 500);
        c1.visualizarSaldo();
        c2.visualizarSaldo();


    }
}