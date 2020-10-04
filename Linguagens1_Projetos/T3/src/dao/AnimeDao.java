package dao;

import models.Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeDao implements Dao<Anime> {
    private Connection connection;
    private String dbConnectionString = "jdbc:sqlite:database.db";

    public AnimeDao(){
        try {
            connection = DriverManager.getConnection((dbConnectionString));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca no banco de dados e salva os dados encontrados em uma Lista
     * <br> Caso tenha erro, imprime no console
     * @return Lista com os dados encontrados no banco de dados
     */
    @Override
    public List<Anime> getAll() {
        List<Anime> animes = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM animes");
            while (result.next()){
                Anime anime = new Anime(
                        result.getString("url"),
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getInt("quantEpisodios"),
                        result.getDouble("nota")
                );
                animes.add(anime);
            }
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return animes;
    }

    /**
     * Adiciona o anime ao banco de dados
     * <br> Caso tenha erro, imprime no console
     * @param anime Objeto do anime a ser adicionado
     */
    @Override
    public void create(Anime anime) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cartas (url, nome, sinopse, quantEpisodios, nota) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, anime.getUrl());
            preparedStatement.setString(2, anime.getNome());
            preparedStatement.setString(3, anime.getSinopse());
            preparedStatement.setInt(4, anime.getQuantEpisodios());
            preparedStatement.setDouble(5, anime.getNota());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
