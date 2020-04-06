//Yago Garcia Battaggia  18.01099-7

public class Contas {
    private static int counterContas;
    private int idConta;
    private double saldo;
    private Usuarios titular;

    public Contas(double saldo, Usuarios titular){
        counterContas ++;
        idConta = counterContas;
        this.saldo = saldo;
        this.titular = titular;

    }

    //Retorna o id da conta
    public int getIdConta() {
        return idConta;
    }
    //Retorna o saldo disponível na conta
    public double getSaldo() {
        return saldo;
    }
    // Retorna titular da conta
    public Usuarios getTitular() {
        return titular;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }
    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

}