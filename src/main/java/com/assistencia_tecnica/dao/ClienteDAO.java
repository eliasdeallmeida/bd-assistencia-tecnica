package com.assistencia_tecnica.dao;

import com.assistencia_tecnica.model.Cliente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DBConnection {

    private static final String INSERT_CLIENTES_SQL = "INSERT INTO clientes (nome, cpf, email, data_nascimento, id_endereco) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_CLIENTES_SQL = "SELECT * FROM clientes;";
    private static final String SELECT_CLIENTES_SQL = "SELECT id, nome, cpf, email, data_nascimento, id_endereco FROM clientes WHERE id = ?";
    private static final String UPDATE_CLIENTES_SQL = "UPDATE clientes SET nome = ?, cpf = ?, email = ?, data_nascimento = ?, id_endereco = ? WHERE id = ?;";
    private static final String DELETE_CLIENTES_SQL = "DELETE FROM clientes WHERE id = ?;";
    private static final String COUNT_CLIENTES_SQL = "SELECT count(1) FROM clientes;";

    public void insert(Cliente entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_CLIENTES_SQL)) {
            preparedStatement.setString(1, entity.getNome());
            preparedStatement.setString(2, entity.getCpf());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setDate(4, entity.getDataNascimento());
            preparedStatement.setInt(5, entity.getIdEndereco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> selectAll() {
        List<Cliente> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_CLIENTES_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String email = resultSet.getString("email");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                Integer idEndereco = resultSet.getInt("id_endereco");
                entities.add(new Cliente(id, nome, cpf, email, dataNascimento, idEndereco));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public Cliente select(int id) {
        Cliente entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_CLIENTES_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String email = resultSet.getString("email");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                Integer idEndereco = resultSet.getInt("id_endereco");
                entity = new Cliente(id, nome, cpf, email, dataNascimento, idEndereco);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(Cliente entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_CLIENTES_SQL)) {
            statement.setString(1, entity.getNome());
            statement.setString(2, entity.getCpf());
            statement.setString(3, entity.getEmail());
            statement.setDate(4, entity.getDataNascimento());
            statement.setInt(5, entity.getIdEndereco());
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
        try (PreparedStatement statement = prepareSQL(DELETE_CLIENTES_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_CLIENTES_SQL)) {
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
