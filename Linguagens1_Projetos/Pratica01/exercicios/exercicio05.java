import java.util.Scanner;
class Exercicio05{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        System.out.print("Informe qual numero de Fibonnacci deseja: ");
        numero = scanner.nextInt();
        double[] sequencia = new double[numero];
        if(numero == 0){
            System.out.println(numero);
        }else if(numero == 1){
            System.out.println(numero);
        }else if(numero == 2){
                System.out.println("1");
        }else{
            sequencia[0] = 0;
            sequencia[1] = 1;
            for(int i = 2; i < numero ; i++){
            sequencia[i] = (sequencia[i-1] + sequencia[i-2]);
            }
        System.out.println(sequencia[numero-1]);
        }
       
    }
}