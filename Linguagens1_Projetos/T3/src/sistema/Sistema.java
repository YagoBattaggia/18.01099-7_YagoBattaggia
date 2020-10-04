package sistema;

import dao.AnimeDao;
import dao.MangaDao;
import models.Anime;
import models.Manga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Sistema {
    private String name;
    private Scanner scanner;
    private List<Anime> listAnimes;
    private AnimeDao animeDao;
    private MangaDao mangaDao;
    private List<Manga> listManga;
    private int opcao;


    public Sistema() {
        scanner = new Scanner(System.in);
        listAnimes = new ArrayList<>();
        animeDao = new AnimeDao();
        mangaDao = new MangaDao();
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
                    menuAnime();
                    anime();
                    break;
                case 2:
                    menuManga();
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
    private void menuAnime() {
        System.out.println("Escolha qual você deseja checar:");
        System.out.println("1-Procurar Anime");
        System.out.println("2-Exibir animes registrados");
        System.out.println("0-Voltar");
    }
    private void menuManga() {
        System.out.println("Escolha qual você deseja checar:");
        System.out.println("1-Procurar Manga");
        System.out.println("2-Exibir animes registrados");
        System.out.println("0-Voltar");
    }

    private void anime() throws IOException, InterruptedException {
        boolean animeRun = true;
        do {
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
                    animeRun = false;
                    break;
                case 1:
                    Anime anime;
                    System.out.println("Qual nome do Anime:");
                    name = scanner.nextLine();
                    anime = animeDao.getOneData(name);
                    if (anime == null) {
                        System.out.println("Não encontrado no Banco de Dados, fazendo request!");
                        requestAPI(name,"anime");
                    } else {
                        System.out.println(anime);
                    }
                    break;
                case 2:
                    listAnimes = animeDao.getAll();
                    System.out.println("Lista de animes cadastrados: ");
                    listAnimes.forEach(animes -> System.out.println(animes));
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (animeRun);
    }

    private void manga() throws IOException, InterruptedException{
                boolean MangaRun = true;
        do {
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
                    MangaRun = false;
                    break;
                case 1:
                    Manga manga;
                    System.out.println("Qual nome do Manga:");
                    name = scanner.nextLine();
                    manga = mangaDao.getOneData(name);
                    if (manga == null) {
                        System.out.println("Não encontrado no Banco de Dados, fazendo request!");
                        requestAPI(name,"manga");
                    } else {
                        System.out.println(manga);
                    }
                    break;
                case 2:
                    listManga = mangaDao.getAll();
                    System.out.println("Lista de mangas cadastrados: ");
                    listManga.forEach(mangas -> System.out.println(mangas));
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (MangaRun);






















    }

}
