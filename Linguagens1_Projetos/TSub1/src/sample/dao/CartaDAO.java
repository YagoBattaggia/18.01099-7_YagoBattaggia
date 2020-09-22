package sample.dao;

import sample.models.Carta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yago Garcia Battaggia - 18.01099-7
 * @since 21/09/2020
 */

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

    /**
     * Busca no banco de dados e salva os dados encontrados em uma Lista
     * <br> Caso tenha erro, imprime no console
     * @return Lista com os dados encontrados no banco de dados
     */

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

    /**
     * Atualiza os dados da carta recebida no banco de dados
     * <br> Caso tenha erro, imprime no console
     * @return Retorna boolean caso a carta tenha sido alterada no banco de dados
     * @param carta Objeto da carta atualizado
     */

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

    /**
     * Deleta a carta recebida do banco de dados
     * <br> Caso tenha erro, imprime no console
     * @param id o id da carta a ser excluida
     */

    @Override
    public void delete(String id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cartas WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Adiciona a carta ao banco de dados
     * <br> Caso tenha erro, imprime no console
     * @param carta Objeto da carta a ser adicionada
     */
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
