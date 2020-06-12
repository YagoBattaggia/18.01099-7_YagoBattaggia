package maua.sistema;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    //ArrayList<Usuario> usuarios;

    public void run() {
        autentica();
    }

    protected boolean autentica() {

        boolean autenticado = false;
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        System.out.println("******AUTENTICAÇÃO******");
        System.out.print("Insira o Login: ");
        String login = scanner.nextLine();
        String senha = new String(console.readPassword("Insira a Senha: "));
        System.out.println(senha);
    }
}