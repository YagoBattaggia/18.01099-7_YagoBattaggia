//Yago Garcia Battaggia  18.01099-7

public class Usuarios {
    private String nome;
    private String senha;
    private String email;

    public Usuarios(String nome, String senha, String email){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
    //Retorna o email do usuário
    public String getEmail() {
        return email;
    }
    //Retorna o nome do usuário
    public String getNome() {
        return nome;
    }
    //Definir email do usuário
    public void setEmail(String email) {
        this.email = email;
    }
    //Definir nome do usuário
    public void setNome(String nome) {
        this.nome = nome;
    }
    // //Valida se a senha recebida está correta
    // public boolean validarSenha(String senha){
    //     return senha.equals(this.senha);
    // }

    //Para Debug, não será usado em produção
    //getInfo

}