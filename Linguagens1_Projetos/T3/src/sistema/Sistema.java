package sistema;

import dao.AnimeDao;
import dao.MangaDao;
import models.Anime;
import models.Manga;
import parsers.AnimeParser;
import parsers.MangaParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Classe concreta que representa o sistema principal. Ela que vai executar o sistema.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/10/2020
 * @version 1.0
 */
public class Sistema {
    private String name;
    private Scanner scanner;
    private List<Anime> listAnimes;
    private AnimeDao animeDao;
    private MangaDao mangaDao;
    private List<Manga> listManga;
    private int opcao;


    /**
     * scanner é iniciado
     * listAnime é iniciado
     * listManga é iniciado
     * animeDao é iniciado
     * mangaDao é iniciado
     */
    public Sistema() {
        scanner = new Scanner(System.in);
        listAnimes = new ArrayList<>();
        listManga = new ArrayList<>();
        animeDao = new AnimeDao();
        mangaDao = new MangaDao();
    }
    /**
     * Método run, ele vai ser o principal metodo do programa e vai funcionar até escolherem a opção 0.
     */
    public void run() throws IOException, InterruptedException {
        boolean alive = true;
        do {
            menu();
            while(true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
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

    /**
     * Mostra um menu de opcoes para a tela inicial
     */
    private void menu() {
        System.out.println("Escolha qual você deseja checar:");
        System.out.println("1-Anime");
        System.out.println("2-Manga");
        System.out.println("0-Sair");
    }
    /**
     * Mostra um menu de opcoes para a opcao 1 - anime
     */
    private void menuAnime() {
        System.out.println("Escolha qual você deseja checar:");
        System.out.println("1-Procurar Anime");
        System.out.println("2-Exibir animes registrados");
        System.out.println("0-Voltar");
    }
    /**
     * Mostra um menu de opcoes para a opcao 2 - manga
     */
    private void menuManga() {
        System.out.println("Escolha qual você deseja checar:");
        System.out.println("1-Procurar Manga");
        System.out.println("2-Exibir mangas registrados");
        System.out.println("0-Voltar");
    }
    /**
     * Pergunta pro usuario se ele quer voltar, mostrar os animes cadastrados ou cadastrar um anime
     * <br> e da um throw se houver excecoes
     */
    private void anime() throws IOException, InterruptedException {
        boolean animeRun = true;
        do {
            while(true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
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
                        System.out.println(requestAnimeAPI(name));

                    } else {
                        System.out.println(anime);
                    }
                    menuAnime();
                    break;
                case 2:
                    listAnimes = animeDao.getAll();
                    System.out.println("Lista de animes cadastrados: ");
                    listAnimes.forEach(System.out::println);
                    menuAnime();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    menuAnime();
            }
        } while (animeRun);
    }
    /**
     * Pergunta pro usuario se ele quer voltar, mostrar os mangas cadastrados ou cadastrar um manga
     * <br> e da um throw se houver excecoes
     */
    private void manga() throws IOException, InterruptedException{
        boolean MangaRun = true;
        do {
            while(true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
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
                        Manga result = requestMangaAPI(name);
                        System.out.println(result);
                    } else {
                        System.out.println(manga);
                    }
                    menuManga();
                    break;
                case 2:
                    listManga = mangaDao.getAll();
                    System.out.println("Lista de mangas cadastrados: ");
                    listManga.forEach(System.out::println);
                    System.out.println(listManga);
                    menuManga();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (MangaRun);
    }
    /**
     * Busca na API o manga que é passado
     * <br> e da um throw se houver excecoes
     * @param name Nome do manga que vai ser requisitado pela API
     */
    private Manga requestMangaAPI(String name) throws IOException, InterruptedException {

            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET().uri(URI.create("https://api.jikan.moe/v3/search/manga?q=" + name.replace(" ", "%20"))).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            MangaParser mangaParser = new MangaParser();
            Manga manga = mangaParser.ParseJSON(response.body());
            mangaDao.create(manga);
            return manga;
    }
    /**
     * Busca na API o anime que é passado
     * <br> e da um throw se houver excecoes
     * @param name Nome do anime que vai ser requisitado pela API
     */
    private Anime requestAnimeAPI(String name) throws IOException, InterruptedException {
        System.out.println("Fazendo Request");
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://api.jikan.moe/v3/search/anime?q=" + name.replace(" ", "%20"))).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        AnimeParser animeParser = new AnimeParser();
        Anime anime = animeParser.ParseJSON(response.body());
        animeDao.create(anime);
        return anime;
    }

}
