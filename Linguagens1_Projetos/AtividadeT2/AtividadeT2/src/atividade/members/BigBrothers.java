package atividade.members;
import atividade.models.Membro;

public class BigBrothers extends Membro{
    public BigBrothers(String nome, String email) {
        super(nome, email);        
    }
    @Override
    public void Apresenta(){
        System.out.println("Apresentação do Membro: \nnome: " 
        + nome +"\n" + "email: " 
        + email + "\n"+ "funcao: " 
        +  "BigBrothers" + "\n";);
    }

}