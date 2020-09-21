package sample.models;

public class Carta {
    private String url;
    private String id;
    private String nome;
    private String raridade;
    private String serie;
    private String colecao;

    public Carta(String url, String id, String nome, String raridade, String serie, String colecao){
        this.url = url;
        this.id = id;
        this.nome = nome;
        this.raridade = raridade;
        this.serie = serie;
        this.colecao = colecao;
    }
}
