import java.util.Scanner;
class Exercicio04{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase;
        System.out.print("Informe a frase: ");
        frase = scanner.nextLine().toLowerCase().replaceAll(" ","");
        StringBuffer novafrase = new StringBuffer();
        for(int i = frase.length()-1; i >= 0 ; i--) {
            novafrase = novafrase.append(frase.charAt(i));
            }
        if(frase.equalsIgnoreCase(novafrase.toString())) {
                System.out.print("String é palindromo\n");
                } else {
                System.out.print("String não é palindromo\n");
                }
                System.out.print("Frase antiga: "+frase+"\nFrase nova: "+novafrase);
                }
}