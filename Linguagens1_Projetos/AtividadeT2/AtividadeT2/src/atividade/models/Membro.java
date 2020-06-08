package atividade.models;

import atividade.enumerates.EnumMembro;
import atividade.interfaces.Apresentacao;
import atividade.interfaces.PostarMensagem;

/**
 * Classe responsável pelos membros da equipe, por meio dela os membros são registrados e realizam suas devidas funções.
 *
 * @author Yago Garcia Battaggia - 18.01099-7@maua.br
 * @author Guilherme Ballardini - 18.01353-8@maua.br
 * @version 1.0
 */
public abstract class Membro implements Apresentacao{
    private EnumMembro funcao;
    private String email;
    private String nome;

    
    public Membro(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Apresentação do Membro: \nnome: " 
        + nome +"\n" + "email: " 
        + email + "\n"+ "funcao: " 
        +  funcao + "\n";
    }
}