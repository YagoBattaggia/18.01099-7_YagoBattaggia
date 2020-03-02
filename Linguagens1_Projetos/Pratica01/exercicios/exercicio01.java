import java.util.Scanner;
class Exercicio01{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String RA, telefone, nome, email;
        int idade;
        System.out.print("Informe o RA: ");
        RA = scanner.nextLine();
        System.out.print("Informe o nome completo do aluno: ");
        nome = scanner.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = scanner.nextLine();
        System.out.print("Informe o email: ");
        email = scanner.nextLine();
        System.out.print("Informe a idade do aluno: ");
        idade = scanner.nextInt();

        System.out.println("RA: " + RA + "\nNome: " + nome + "\nTelefone: " + telefone + "\nEmail: " + email + "\nIdade: " + idade);

    }
}