package atividade.members;
import atividade.models.Membro;

public class ScriptGuys extends Membro{
    public ScriptGuys(String nome, String email) {
        super(nome, email);        
    }
    @Override
    public void Apresenta(){
        System.out.println(toString());
    }

    @Override
    public void PostarMensagem()
}