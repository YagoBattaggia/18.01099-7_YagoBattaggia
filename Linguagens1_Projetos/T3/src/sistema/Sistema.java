package sistema;

import dao.AnimeDao;
import models.Anime;
import models.Manga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private Scanner scanner;
    private List<Anime> listAnimes;
    private AnimeDao animeDao;
    private List<Manga> listManga;
    private int opcao;


    public Sistema() {
        scanner = new Scanner(System.in);
        listAnimes = new ArrayList<>();
        animeDao = new AnimeDao();
        scanner = new Scanner(System.in);

    }

    public void run(){
        boolean alive = true;
        do {
            menu();
            while(true) {
                try {
                    opcao = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor inserir um numero valido: ");

                }
            }
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:
                    anime();
                    break;
                case 2:
                    manga();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (alive);
    }


    private void menu() {
        System.out.println("Escolha qual você deseja checar:");
        System.out.println("1-Anime");
        System.out.println("2-Manga");
        System.out.println("0-Sair");
    }
    private void anime(){

    }
    private void manga(){

    }

}
