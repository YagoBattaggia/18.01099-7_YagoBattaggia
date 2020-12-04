package dao;

import enums.Profissoes;
import enums.Racas;
import models.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que vai servir de DAO para o personagem.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/12/2020
 * @version 1.0
 */
public class PersonagemDAO implements Dao<Personagem>{
    private Connection connection;
    private String dbConnectionString = "jdbc:sqlite:sqlite.db";

    /**
     * connection é obtido pela funcao DriverManager.getConnection
     */
    public PersonagemDAO(){
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

    /**
     * Adiciona o personagem ao banco de dados
     * <br> Caso tenha erro, imprime no console
     * @param personagem Objeto do personagem a ser adicionado
     */
    @Override
    public void create(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO personagens (nomePersonagem, raca, profissao, mana, ataque, ataqueM, defesa, defesaM, velocidade, destreza, experiencia, nivelAtual) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca().toString());
            preparedStatement.setString(3, personagem.getProfissao().toString());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAtaque());
            preparedStatement.setInt(6, personagem.getAtaqueM());
            preparedStatement.setInt(7, personagem.getDefesa());
            preparedStatement.setInt(8, personagem.getDefesaM());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExperiencia());
            preparedStatement.setInt(12, personagem.getNivelAtual());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove um personagem do banco de dados
     * <br> Caso tenha erro, imprime no console
     * @param ID id do personagem a ser deletado do banco de dados
     */
    @Override
    public boolean delete(int ID) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM personagens where ID = ?");
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Edita um personagem do banco de dados
     * <br> Caso tenha erro, imprime no console
     * @param personagem objeto personagem que deve ser substituído no banco de dados
     */
    @Override
    public void update(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE personagens SET nomePersonagem = ?, raca = ?, profissao = ?, mana = ?, ataque = ?, ataqueM = ?, defesa = ?, defesaM = ?, velocidade = ?, destreza = ?, experiencia = ?, nivelAtual = ? WHERE ID = ?");
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca().toString());
            preparedStatement.setString(3, personagem.getProfissao().toString());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAtaque());
            preparedStatement.setInt(6, personagem.getAtaqueM());
            preparedStatement.setInt(7, personagem.getDefesa());
            preparedStatement.setInt(8, personagem.getDefesaM());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExperiencia());
            preparedStatement.setInt(12, personagem.getNivelAtual());
            preparedStatement.setInt(13, personagem.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca no banco de dados e salva um dado especifico encontrado em uma Lista
     * <br> Caso tenha erro, imprime no
     * @param ID id do personagem que deve ser buscado no banco de dados
     * @return Objeto com os dados encontrados no banco de dados
     */
    @Override
    public Personagem getOneData(int ID) {
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM personagens WHERE ID =" + ID);
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
                result.close();
                return personagem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
