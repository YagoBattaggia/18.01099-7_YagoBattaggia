package atividade.members;
import atividade.models.Membro;

public class HeavyLifters extends Membro{
    public HeavyLifters(String nome, String email) {
        super(nome, email);        
    }
    @Override
    public void Apresenta(){
        System.out.println(toString());
    }
}