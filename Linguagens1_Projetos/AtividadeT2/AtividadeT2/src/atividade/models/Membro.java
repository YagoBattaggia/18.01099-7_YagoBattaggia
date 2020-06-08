package atividade.models;

import atividade.enumerates.EnumMembro;
import atividade.interfaces.Apresentacao;

public class Membro implements Apresentacao{
    private EnumMembro funcao;
    private String email;
    private String nome;
    private String assinaturaRegular;
    private String assinaturaExtra;

    
    public Membro(String nome, String email, int funcao){
        this.nome = nome;
        this.email = email;
        if (funcao == 1){
            this.funcao = EnumMembro.MOBILE_MEMBERS;
            this.assinaturaRegular = "Happy Coding!";
            this.assinaturaExtra = "MAsK_S0c13ty";
        } else if (funcao == 2){
            this.funcao = EnumMembro.HEAVY_LIFTERS;
            this.assinaturaRegular = "Podem contar conosco!";
            this.assinaturaExtra = "N00b_qu3_n_Se_r3pita.bat";
        } else if (funcao == 3){
            this.funcao = EnumMembro.SCRIPTGUYS;
            this.assinaturaRegular = "Prazer em ajudar novos amigos de código!";
            this.assinaturaExtra = "QU3Ro_S3us_r3curs0s.py";
        } else if (funcao == 4){
            this.funcao = EnumMembro.BIG_BROTHERS;
            this.assinaturaRegular = "Sempre ajudando as pessoas membros ou não S2!";
            this.assinaturaExtra = "...";
        }
    }
}