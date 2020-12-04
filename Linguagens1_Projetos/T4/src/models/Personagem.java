package models;

public class Personagem {
    private int id;
    private String nome;
    private String raca;
    private String profissao;
    private int mana;
    private int ataque;
    private int ataqueM;
    private int defesa;
    private int defesaM;
    private int velocidade;
    private int destreza;
    private int experiencia;
    private int nivelAtual;

    public Personagem(int id, String nome, String raca, String profissao, int mana, int ataque, int ataqueM, int defesa, int defesaM, int velocidade, int destreza, int experiencia, int nivelAtual) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.profissao = profissao;
        this.mana = mana;
        this.ataque = ataque;
        this.ataqueM = ataqueM;
        this.defesa = defesa;
        this.defesaM = defesaM;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.experiencia = experiencia;
        this.nivelAtual = nivelAtual;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setAtaqueM(int ataqueM) {
        this.ataqueM = ataqueM;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setDefesaM(int defesaM) {
        this.defesaM = defesaM;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getProfissao() {
        return profissao;
    }

    public int getMana() {
        return mana;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueM() {
        return ataqueM;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getDefesaM() {
        return defesaM;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }
}
