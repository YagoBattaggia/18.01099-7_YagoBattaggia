package sample.models;

/**
 * @author Yago Garcia Battaggia - 18.01099-7
 * @since 21/09/2020
 */
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

    /**
     * @return Url da carta
     */
    public String getUrl() {
        return url;
    }
    /**
     * Altera a URL da Carta
     * @param url Novo url para ser alterado
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * @return Id da carta
     */
    public String getId() {
        return id;
    }
    /**
     * Altera o ID da Carta
     * @param id Novo id para ser alterado
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return Nome da carta
     */
    public String getNome() {
        return nome;
    }
    /**
     * Altera o Nome da Carta
     * @param nome Novo nome para ser alterado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return Raridade da carta
     */
    public String getRaridade() {
        return raridade;
    }
    /**
     * Altera a Raridade da Carta
     * @param raridade Nova raridade para ser alterado
     */
    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }
    /**
     * @return Serie da carta
     */
    public String getSerie() {
        return serie;
    }
    /**
     * Altera a Serie da Carta
     * @param serie Nova serie para ser alterado
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }
    /**
     * @return Colecao da carta
     */
    public String getColecao() {
        return colecao;
    }
    /**
     * Altera a Colecao da Carta
     * @param colecao Nova colecao para ser alterado
     */
    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", raridade='" + raridade + '\'' +
                ", serie='" + serie + '\'' +
                ", colecao='" + colecao + '\'' +
                '}';
    }
}
