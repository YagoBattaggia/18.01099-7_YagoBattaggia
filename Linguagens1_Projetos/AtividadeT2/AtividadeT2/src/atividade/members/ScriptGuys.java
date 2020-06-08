package atividade.members;
import atividade.models.Membro;
/**
 * Classe de um tipo de membro chamado Script Guys
 *      
 * @author Yago Garcia Battaggia - 18.01099-7@maua.br
 * @author Guilherme Ballardini - 18.01353-8@maua.br
 * @version 1.0
 */
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