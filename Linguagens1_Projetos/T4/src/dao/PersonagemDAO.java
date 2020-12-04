package dao;

import enums.Profissoes;
import enums.Racas;
import models.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO implements Dao{
    private Connection connection;
    private String dbConnectionString = "jdbc:sqlite:sqlite.db";

    public PersonagemDAO(){
        try {
            connection = DriverManager.getConnection((dbConnectionString));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List getAll() {
        List<Personagem> personagens = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM personagens");
            while (result.next()){
                Personagem personagem = new Personagem(
                        result.getInt("ID"),
                        result.getString("nomePersonagem"),
                        Racas.valueOf(result.getString("raca")),
                        Profissoes.valueOf(result.getString("profissao")),
                        result.getInt("mana"),
                        result.getInt("ataque"),
                        result.getInt("ataqueM"),
                        result.getInt("defesa"),
                        result.getInt("defesaM"),
                        result.getInt("velocidade"),
                        result.getInt("destreza"),
                        result.getInt("experiencia"),
                        result.getInt("nivelAtual")
                );
                personagens.add(personagem);
            }
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personagens;
    }

    @Override
    public void create(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public Object getOneData(String nome) {
        return null;
    }
}
