package sample.dao;

import sample.models.Carta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaDAO implements DAO<Carta> {
    private Connection connection;
    private String dbConnectionString = "jdbc:sqlite:database.db";

    public CartaDAO(){
        try {
            connection = DriverManager.getConnection((dbConnectionString));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Carta> getAll() {
        List<Carta> cartas = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cartas");
            while (result.next()){
                Carta carta = new Carta(
                        result.getString("url"),
                        result.getString("id"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao")
                );
                cartas.add(carta);
            }
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartas;
    }

    @Override
    public boolean update(Carta carta) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cartas SET url = ?, nome = ?, raridade = ?, serie = ?, colecao = ? WHERE id = ?");
            preparedStatement.setString(1, carta.getUrl());
            preparedStatement.setString(2, carta.getNome());
            preparedStatement.setString(3, carta.getRaridade());
            preparedStatement.setString(4, carta.getSerie());
            preparedStatement.setString(5, carta.getColecao());
            preparedStatement.setString(6, carta.getId());
            int retorno = preparedStatement.executeUpdate();
            return retorno != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void delete(Carta carta) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE * FROM cartas WHERE id = ?");
            preparedStatement.setString(1, carta.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Carta carta) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cartas (url, nome, raridade, serie, colecao, id) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, carta.getUrl());
            preparedStatement.setString(2, carta.getNome());
            preparedStatement.setString(3, carta.getRaridade());
            preparedStatement.setString(4, carta.getSerie());
            preparedStatement.setString(5, carta.getColecao());
            preparedStatement.setString(6, carta.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
