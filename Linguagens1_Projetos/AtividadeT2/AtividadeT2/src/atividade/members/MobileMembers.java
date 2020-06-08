package atividade.members;
import atividade.models.Membro;

public class MobileMembers extends Membro{
    public MobileMembers(String nome, String email) {
        super(nome, email);        
    }

    @Override
    public void Apresenta(){
        System.out.println(toString());
    }
}