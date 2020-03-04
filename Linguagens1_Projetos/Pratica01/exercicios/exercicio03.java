import java.util.Scanner;
class Exercicio03{
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuario1, usuario2, senha1 ,senha2;
        senha2 = "";
        usuario2 = "";
        System.out.print("Informe o usuario1: ");
        usuario1 = scanner.nextLine();
        System.out.print("Informe a senha1: ");
        senha1 = scanner.nextLine();
        while(!(senha1.equals(senha2)) && !(usuario1.equals(usuario2))){
            System.out.print("Informe o usuario2: ");
            usuario2 = scanner.nextLine();
            System.out.print("Informe a senha2: ");
            senha2 = scanner.nextLine();
        }
        System.out.print("ACERTOU!!");
    } 
}