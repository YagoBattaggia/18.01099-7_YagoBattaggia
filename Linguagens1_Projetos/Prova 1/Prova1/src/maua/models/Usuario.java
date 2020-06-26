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

    /**
     * Construtor da classe Usuario
     * @param nome - Recebe uma string contendo o nome do usuário
     * @param email - Recebe uma string contendo o email do usuário
     * @param senha - Recebe uma string contendo a senha do usuário
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
     */
    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * @return Retorna o email do usuário.
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
    */
    public String getEmail() {
        return email;
    }
    /**
     * @return Retorna o nome do usuário.
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
    */
    public String getNome() {
        return nome;
    }

    /**
     * Função para checar se uma string é a senha atual do usuário
     * @param tentativa - String contendo a tentativa de senha.
     * @return Boolean TRUE caso a senha esteja correta.
     * @author Yago Garcia Battaggia - 18.01099-7@maua.br
     * @since 12/06/2020
     * @version 1.0
    */
    public boolean checaSenha(String tentativa){
        return senha.equals(tentativa);
    }

}