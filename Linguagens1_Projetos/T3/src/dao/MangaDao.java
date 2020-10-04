package dao;

import models.Anime;
import models.Manga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MangaDao implements Dao<Manga> {
    private Connection connection;
    private String dbConnectionString = "jdbc:sqlite:database.db";

    public MangaDao(){
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
    public List<Manga> getAll() {
        List<Manga> mangas = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM mangas");
            while (result.next()){
                Manga manga = new Manga(
                        result.getString("url"),
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getInt("quantCapitulos"),
                        result.getInt("quantVolumes"),
                        result.getString("tipo"),
                        result.getDouble("nota")
                );
                mangas.add(manga);
            }
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mangas;
    }

    @Override
    public Manga getOneData(String nome) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM mangas WHERE nome LIKE '%" + nome + "%'");
            while (result.next()) {
                Manga manga = new Manga(
                        result.getString("url"),
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getInt("quantCapitulos"),
                        result.getInt("quantVolumes"),
                        result.getString("tipo"),
                        result.getDouble("nota")
                );
                result.close();
                return manga;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Adiciona o anime ao banco de dados
     * <br> Caso tenha erro, imprime no console
     * @param manga Objeto do anime a ser adicionado
     */
    @Override
    public void create(Manga manga) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mangas (url, nome, sinopse, quantCapitulos, quantVolumes, tipo, nota) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, manga.getUrl());
            preparedStatement.setString(2, manga.getNome());
            preparedStatement.setString(3, manga.getSinopse());
            preparedStatement.setInt(4, manga.getQuantCapitulos());
            preparedStatement.setInt(5, manga.getQuantVolumes());
            preparedStatement.setString(6, manga.getTipo());
            preparedStatement.setDouble(7, manga.getNota());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
