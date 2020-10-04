package models;
/**
 * Classe concreta que representa um anime. Ela define o que é um anime e como se cria um.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/10/2020
 * @version 1.0
 */
public class Anime {
    private String url;
    private String nome;
    private String sinopse;
    private int quantEpisodios;
    private double nota;

    /**
     * @param url Link do anime.
     * @param nome Nome do anime.
     * @param sinopse Sinopse do anime.
     * @param quantEpisodios Quantidade de episódios do anime.
     * @param nota Nota do anime no MyAnimeList.
     */
    public Anime(String url, String nome, String sinopse, int quantEpisodios, double nota) {
        this.url = url;
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantEpisodios = quantEpisodios;
        this.nota = nota;
    }
    /**
     * Método getUrl.
     * @return Link url do anime.
     */
    public String getUrl() {
        return url;
    }
    /**
     * Método getNome.
     * @return Nome do anime.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Método getSinopse.
     * @return Sinopse do anime.
     */
    public String getSinopse() {
        return sinopse;
    }
    /**
     * Método getQuantEpisodios.
     * @return Quantidade de episódios do anime.
     */
    public int getQuantEpisodios() {
        return quantEpisodios;
    }
    /**
     * Método getNota.
     * @return Nota do anime no MyAnimeList.
     */
    public double getNota() {
        return nota;
    }
    /**
     * Método getNota.
     * @return Nota do anime no MyAnimeList.
     */
    @Override
    public String toString() {
        return "Anime{" +
                "url='" + url + '\'' +
                ", nome='" + nome + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", quantEpisodios=" + quantEpisodios +
                ", nota=" + nota +
                '}';
    }
}
