import java.util.List;
import java.util.Scanner;
class Exercicio07{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numero;
        int resultado = 0;
        System.out.print("Informe um valor: ");
        numero = scanner.nextLine();
        for(int i = 0; i < numero.length() ; i++){
            int x = Character.getNumericValue(numero.charAt(i));
            resultado += x;
        }
        System.out.println(resultado);
    }
}