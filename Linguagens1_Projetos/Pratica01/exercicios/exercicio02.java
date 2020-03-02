import java.util.Scanner;
class Exercicio02{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String nome1, nome2;
        int idade1, idade2;
        System.out.println("Informe o nome 1: ");
        nome1 = scanner.nextLine();
        System.out.println("Informe a idade 1: ");
        idade1 = scanner.nextInt();
        System.out.println("Informe o nome 2: ");
        nome2 = scanner.nextLine();
        System.out.print("Informe a idade 2: ");
        idade2 = scanner.nextInt();


        System.out.println("Nome 1: " + nome1 + "\nIdade 1: " + idade1 + "\nNome 2: " + nome2 + "\nIdade 2: " + idade2);
        System.out.println("Diferença de idades: " + Math.abs(idade1 - idade2));
        scanner.close();
    }
}