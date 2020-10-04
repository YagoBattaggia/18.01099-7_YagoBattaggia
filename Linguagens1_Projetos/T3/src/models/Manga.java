package models;
/**
 * Classe concreta que representa um manga. Ela define o que é um manga e como se cria um.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/10/2020
 * @version 1.0
 */
public class Manga {
    private String url;
    private String nome;
    private String sinopse;
    private int quantCapitulos;
    private int quantVolumes;
    private String tipo;
    private double nota;

    /**
     * @param url Link do manga.
     * @param nome Nome do manga.
     * @param sinopse Sinopse do manga.
     * @param quantCapitulos Quantidade de capitulos do anime.
     * @param quantVolumes Quantidade de volumes do anime.
     * @param tipo Tipo do anime.
     * @param nota Nota do manga no MyAnimeList.
     */
    public Manga(String url, String nome, String sinopse, int quantCapitulos, int quantVolumes, String tipo, double nota) {
        this.url = url;
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantCapitulos = quantCapitulos;
        this.quantVolumes = quantVolumes;
        this.tipo = tipo;
        this.nota = nota;
    }
    /**
     * Método getUrl.
     * @return Link url do manga.
     */
    public String getUrl() {
        return url;
    }
    /**
     * Método getNome.
     * @return Nome do manga.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Método getSinopse.
     * @return Sinopse do manga.
     */
    public String getSinopse() {
        return sinopse;
    }
    /**
     * Método getQuantCapitulos.
     * @return Quantidade de capitulos do manga.
     */
    public int getQuantCapitulos() {
        return quantCapitulos;
    }
    /**
     * Método getQuantVolumes.
     * @return Quantidade de volumes do manga.
     */
    public int getQuantVolumes() {
        return quantVolumes;
    }
    /**
     * Método getTipo.
     * @return Tipó do anime no MyAnimeList.
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Método getNota.
     * @return Nota do manga no MyAnimeList.
     */
    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "url='" + url + '\'' +
                ", nome='" + nome + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", quantCapitulos=" + quantCapitulos +
                ", quantVolumes=" + quantVolumes +
                ", tipo='" + tipo + '\'' +
                ", nota=" + nota +
                '}';
    }
}
