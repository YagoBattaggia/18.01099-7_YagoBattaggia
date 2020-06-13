package maua.models;

/**
 * Essa classe gerencia e modela o usuário do sistema
 * 
 * @author Yago Garcia Battaggia - 18.01099-7@maua.br
 */
public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }

    public boolean checaSenha(String tentativa){
        if(senha.equals(tentativa)){
            return true;
        } else {
            return false;
        }
    }

}