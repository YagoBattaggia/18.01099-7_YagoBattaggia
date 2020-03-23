import java.util.Scanner;
public class exercicio06{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1,n2, prod = 1, soma = 0;

        System.out.print("Informe os numeros: ");
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        for(int i = n1; i <= n2; i++){
            soma += i;
            prod *= i;

        }
        System.out.println("Soma: "+ soma);
        System.out.println("Produto: "+ prod);
    } 
        
}