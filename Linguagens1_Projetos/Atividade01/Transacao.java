import java.util.Random;

//Yago Garcia Battaggia  18.01099-7

public class Transacao {
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String gerarPagamento(Contas conta, Double valor){
        int random = getRandomNumberInRange(1000, 9999);
        return (conta.getIdConta() + ";" + conta.getTitular().getNome() + ";" + valor + ";" + random);
    }
    public static boolean pagarConta(Contas pagador, Contas recebedor, String qrCode){
        String[] hash = qrCode.split(";");
        if ((Integer.parseInt(hash[0]) == recebedor.getIdConta()) & (hash[1].equals(recebedor.getTitular().getNome()))){
            boolean sacado = pagador.sacar(Double.parseDouble(hash[2]));
            if(sacado){
                recebedor.depositar(Double.parseDouble(hash[2]));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        
        // if (pagador.equals(recebedor){
        //     return false;
        // } else if (pagador.getSaldo() < Double.parseDouble(hash[2])){
        //     return false;
        // } else if (pagador.getSaldo() > Double.parseDouble(hash[2])){
            
        //     return true;
        // }
    }

}