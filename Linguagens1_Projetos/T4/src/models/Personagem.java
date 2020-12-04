package models;

import enums.Profissoes;
import enums.Racas;

/**
 * Classe que representa um personagem. Ela define o que é um personagm e como se cria um.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/12/2020
 * @version 1.0
 */
public class Personagem {
    private int id;
    private String nome;
    private Racas raca;
    private Profissoes profissao;
    private int mana;
    private int ataque;
    private int ataqueM;
    private int defesa;
    private int defesaM;
    private int velocidade;
    private int destreza;
    private int experiencia;
    private int nivelAtual;

    /**
     * @param id id do personagem.
     * @param nome Nome do personagem.
     * @param raca Enum raça do personagem
     * @param profissao Enum de profissão do personagem.
     * @param mana mana do personagem.
     * @param ataque ataque do personagem.
     * @param ataqueM ataque mágico do personagem
     * @param defesa defesa do personagem.
     * @param defesaM defesa mágica do personagem
     * @param velocidade velocidade do personagem
     * @param destreza destreza do personagem
     * @param experiencia experiencia do personagem
     * @param nivelAtual nível atual do personagem
     */
    public Personagem(int id, String nome, Racas raca, Profissoes profissao, int mana, int ataque, int ataqueM, int defesa, int defesaM, int velocidade, int destreza, int experiencia, int nivelAtual) {
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

    @Override
    public String toString() {
        return "Personagem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", raca=" + raca +
                ", profissao=" + profissao +
                ", mana=" + mana +
                ", ataque=" + ataque +
                ", ataqueM=" + ataqueM +
                ", defesa=" + defesa +
                ", defesaM=" + defesaM +
                ", velocidade=" + velocidade +
                ", destreza=" + destreza +
                ", experiencia=" + experiencia +
                ", nivelAtual=" + nivelAtual +
                '}';
    }

    /**
     * Método setNome.
     * @param nome nome do personagem.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método setRaca.
     * @param raca raca do personagem.
     */
    public void setRaca(Racas raca) {
        this.raca = raca;
    }

    /**
     * Método setProfissao.
     * @param profissao profissao do personagem.
     */
    public void setProfissao(Profissoes profissao) {
        this.profissao = profissao;
    }

    /**
     * Método setMana.
     * @param mana mana do personagem.
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Método setAtaque.
     * @param ataque ataque do personagem.
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * Método setAtaqueM.
     * @param ataqueM ataque mágico do personagem.
     */
    public void setAtaqueM(int ataqueM) {
        this.ataqueM = ataqueM;
    }

    /**
     * Método setDefesa.
     * @param defesa defesa do personagem.
     */
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    /**
     * Método setDefesaM.
     * @param defesaM defesa mágica do personagem.
     */
    public void setDefesaM(int defesaM) {
        this.defesaM = defesaM;
    }

    /**
     * Método setVelocidade.
     * @param velocidade velocidade do personagem.
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Método setDestreza.
     * @param destreza destreza do personagem.
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Método setExperiencia.
     * @param experiencia experiencia do personagem.
     */
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Método setNivelAtual.
     * @param nivelAtual nivel atual do personagem.
     */
    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    /**
     * Método getId.
     * @return id do personagem.
     */
    public int getId() {
        return id;
    }
    /**
     * Método getNome.
     * @return nome do personagem.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método getRaca.
     * @return raça do personagem.
     */
    public Racas getRaca() {
        return raca;
    }

    /**
     * Método getProfissao.
     * @return profissao do personagem.
     */
    public Profissoes getProfissao() {
        return profissao;
    }

    /**
     * Método getMana.
     * @return mana do personagem.
     */
    public int getMana() {
        return mana;
    }

    /**
     * Método getAtaque.
     * @return ataque do personagem.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Método getAtaqueM.
     * @return ataque mágico do personagem.
     */
    public int getAtaqueM() {
        return ataqueM;
    }

    /**
     * Método getDefesa.
     * @return defesa do personagem.
     */
    public int getDefesa() {
        return defesa;
    }

    /**
     * Método getDefesaM.
     * @return defesa mágica do personagem.
     */
    public int getDefesaM() {
        return defesaM;
    }

    /**
     * Método getVelocidade.
     * @return velocidade do personagem.
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     * Método getDestreza.
     * @return destreza do personagem.
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Método getExperiencia.
     * @return experiencia do personagem.
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Método getNivelAtual.
     * @return nível atual do personagem.
     */
    public int getNivelAtual() {
        return nivelAtual;
    }
}

