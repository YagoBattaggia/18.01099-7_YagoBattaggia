package models;

public class Manga {
    private String url;
    private String nome;
    private String sinopse;
    private int quantCapitulos;
    private int quantVolumes;
    private String tipo;
    private double nota;

    public Manga(String url, String nome, String sinopse, int quantCapitulos, int quantVolumes, String tipo, double nota) {
        this.url = url;
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantCapitulos = quantCapitulos;
        this.quantVolumes = quantVolumes;
        this.tipo = tipo;
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

    public int getQuantCapitulos() {
        return quantCapitulos;
    }

    public int getQuantVolumes() {
        return quantVolumes;
    }

    public String getTipo() {
        return tipo;
    }

    public double getNota() {
        return nota;
    }
}
