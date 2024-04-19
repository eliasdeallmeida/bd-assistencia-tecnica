package com.assistencia_tecnica.dao;

import com.assistencia_tecnica.model.Cidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO extends DBConnection {

    private static final String INSERT_CIDADES_SQL = "INSERT INTO cidades (descricao, codigo, id_uf) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_CIDADES_SQL = "SELECT * FROM cidades;";
    private static final String SELECT_CIDADES_SQL = "SELECT id, descricao, codigo, id_uf FROM cidades WHERE id = ?";
    private static final String UPDATE_CIDADES_SQL = "UPDATE cidades SET descricao = ?, codigo = ?, id_uf = ? WHERE id = ?;";
    private static final String DELETE_CIDADES_SQL = "DELETE FROM cidades WHERE id = ?;";
    private static final String COUNT_CIDADES_SQL = "SELECT count(1) FROM cidades;";

    public void insert(Cidade entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_CIDADES_SQL)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setInt(2, entity.getCodigo());
            preparedStatement.setInt(3, entity.getIdUf());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cidade> selectAll() {
        List<Cidade> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_CIDADES_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                Integer codigo = resultSet.getInt("codigo");
                Integer idUf = resultSet.getInt("id_uf");
                entities.add(new Cidade(id, descricao, codigo, idUf));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public Cidade select(int id) {
        Cidade entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_CIDADES_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                Integer codigo = resultSet.getInt("codigo");
                Integer idUf = resultSet.getInt("id_uf");
                entity = new Cidade(id, descricao, codigo, idUf);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(Cidade entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_CIDADES_SQL)) {
            statement.setString(1, entity.getDescricao());
            statement.setInt(2, entity.getCodigo());
            statement.setInt(3, entity.getIdUf());
            statement.setInt(4, entity.getId());
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
        try (PreparedStatement statement = prepareSQL(DELETE_CIDADES_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_CIDADES_SQL)) {
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
