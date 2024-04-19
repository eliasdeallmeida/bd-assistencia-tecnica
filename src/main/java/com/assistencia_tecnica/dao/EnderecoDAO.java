package com.assistencia_tecnica.dao;

import com.assistencia_tecnica.model.Endereco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO extends DBConnection {

    private static final String INSERT_ENDERECOS_SQL = "INSERT INTO enderecos (rua, numero, bairro, cep, id_cidade) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_ENDERECOS_SQL = "SELECT * FROM enderecos;";
    private static final String SELECT_ENDERECOS_SQL = "SELECT id, rua, numero, bairro, cep, id_cidade FROM enderecos WHERE id = ?";
    private static final String UPDATE_ENDERECOS_SQL = "UPDATE enderecos SET rua = ?, numero = ?, bairro = ?, cep = ?, id_cidade = ? WHERE id = ?;";
    private static final String DELETE_ENDERECOS_SQL = "DELETE FROM enderecos WHERE id = ?;";
    private static final String COUNT_ENDERECOS_SQL = "SELECT count(1) FROM enderecos;";

    public void insert(Endereco entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ENDERECOS_SQL)) {
            preparedStatement.setString(1, entity.getRua());
            preparedStatement.setString(2, entity.getNumero());
            preparedStatement.setString(3, entity.getBairro());
            preparedStatement.setString(4, entity.getCep());
            preparedStatement.setInt(5, entity.getIdCidade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Endereco> selectAll() {
        List<Endereco> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ENDERECOS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String rua = resultSet.getString("rua");
                String numero = resultSet.getString("numero");
                String bairro = resultSet.getString("bairro");
                String cep = resultSet.getString("cep");
                Integer idUf = resultSet.getInt("id_cidade");
                entities.add(new Endereco(id, rua, numero, bairro, cep, idUf));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public Endereco select(int id) {
        Endereco entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ENDERECOS_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String rua = resultSet.getString("rua");
                String numero = resultSet.getString("numero");
                String bairro = resultSet.getString("bairro");
                String cep = resultSet.getString("cep");
                Integer idUf = resultSet.getInt("id_cidade");
                entity = new Endereco(id, rua, numero, bairro, cep, idUf);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(Endereco entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_ENDERECOS_SQL)) {
            statement.setString(1, entity.getRua());
            statement.setString(2, entity.getNumero());
            statement.setString(3, entity.getBairro());
            statement.setString(4, entity.getCep());
            statement.setInt(5, entity.getIdCidade());
            statement.setInt(6, entity.getId());
            updated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return updated;
    }

    public boolean delete(int id) {
        boolean deleted = false;
        try (PreparedStatement statement = prepareSQL(DELETE_ENDERECOS_SQL)) {
            statement.setInt(1, id);
            deleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_ENDERECOS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        } catch (ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        return count;
    }
}
