package dao;

import models.Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe concreta que vai servir de DAO para o anime.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/10/2020
 * @version 1.0
 */
public class AnimeDao implements Dao<Anime> {
    private Connection connection;
    private String dbConnectionString = "jdbc:sqlite:database.db";

    /**
     * connection é obtido pela funcao DriverManager.getConnection
     */
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
     * Busca no banco de dados e salva um dado especifico encontrado em uma Lista
     * <br> Caso tenha erro, imprime no console
     * @return Objeto com os dados encontrados no banco de dados
     */
    @Override
    public Anime getOneData(String nome) {
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM animes WHERE nome LIKE '%"+nome+"%'");
            while (result.next()){
                Anime anime = new Anime(
                        result.getString("url"),
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getInt("quantEpisodios"),
                        result.getDouble("nota")
                );
                result.close();
                return anime;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Adiciona o anime ao banco de dados
     * <br> Caso tenha erro, imprime no console
     * @param anime Objeto do anime a ser adicionado
     */
    @Override
    public void create(Anime anime) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO animes (url, nome, sinopse, quantEpisodios, nota) VALUES (?,?,?,?,?)");
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
