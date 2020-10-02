package models;

public class Anime {
    private String url;
    private String nome;
    private String sinopse;
    private int quantEpisodios;
    private double nota;

    public Anime(String url, String nome, String sinopse, int quantEpisodios, double nota) {
        this.url = url;
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantEpisodios = quantEpisodios;
        this.nota = nota;
    }

    public String getUrl() {
        return url;
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getQuantEpisodios() {
        return quantEpisodios;
    }

    public double getNota() {
        return nota;
    }

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
