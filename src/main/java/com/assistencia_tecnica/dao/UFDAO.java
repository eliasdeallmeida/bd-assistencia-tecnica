package com.assistencia_tecnica.dao;

import com.assistencia_tecnica.model.UF;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UFDAO extends DBConnection {

    private static final String INSERT_UFS_SQL = "INSERT INTO ufs (descricao, codigo) VALUES (?, ?);";
    private static final String SELECT_ALL_UFS_SQL = "SELECT * FROM ufs;";
    private static final String SELECT_UFS_SQL = "SELECT id, descricao, codigo FROM ufs WHERE id = ?";
    private static final String UPDATE_UFS_SQL = "UPDATE ufs SET descricao = ?, codigo = ? WHERE id = ?;";
    private static final String DELETE_UFS_SQL = "DELETE FROM ufs WHERE id = ?;";
    private static final String COUNT_UFS_SQL = "SELECT count(1) FROM ufs;";

    public void insert(UF entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_UFS_SQL)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setInt(2, entity.getCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UF> selectAll() {
        List<UF> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_UFS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                Integer codigo = resultSet.getInt("codigo");
                entities.add(new UF(id, descricao, codigo));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public UF select(int id) {
        UF entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_UFS_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                Integer codigo = resultSet.getInt("codigo");
                entity = new UF(id, descricao, codigo);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(UF entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_UFS_SQL)) {
            statement.setString(1, entity.getDescricao());
            statement.setInt(2, entity.getCodigo());
            statement.setInt(3, entity.getId());
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
        try (PreparedStatement statement = prepareSQL(DELETE_UFS_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_UFS_SQL)) {
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
