package com.assistencia_tecnica.dao;

import com.assistencia_tecnica.model.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO extends DBConnection {

    private static final String INSERT_EMPRESAS_SQL = "INSERT INTO empresas (nome_fantasia, cnpj, logo, slogan, id_endereco) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_EMPRESAS_SQL = "SELECT * FROM empresas;";
    private static final String SELECT_EMPRESAS_SQL = "SELECT id, nome_fantasia, cnpj, logo, slogan, id_endereco FROM empresas WHERE id = ?";
    private static final String UPDATE_EMPRESAS_SQL = "UPDATE empresas SET nome_fantasia = ?, cnpj = ?, logo = ?, slogan = ?, id_endereco = ? WHERE id = ?;";
    private static final String DELETE_EMPRESAS_SQL = "DELETE FROM empresas WHERE id = ?;";
    private static final String COUNT_EMPRESAS_SQL = "SELECT count(1) FROM empresas;";

    public void insert(Empresa entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_EMPRESAS_SQL)) {
            preparedStatement.setString(1, entity.getNomeFantasia());
            preparedStatement.setString(2, entity.getCnpj());
            preparedStatement.setBytes(3, entity.getLogo());
            preparedStatement.setString(4, entity.getSlogan());
            preparedStatement.setInt(5, entity.getIdEndereco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Empresa> selectAll() {
        List<Empresa> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_EMPRESAS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nomeFantasia = resultSet.getString("nome_fantasia");
                String cnpj = resultSet.getString("cnpj");
                byte[] logo = resultSet.getBytes("logo");
                String slogan = resultSet.getString("slogan");
                Integer idEndereco = resultSet.getInt("id_endereco");
                entities.add(new Empresa(id, nomeFantasia, cnpj, logo, slogan, idEndereco));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public Empresa select(int id) {
        Empresa entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_EMPRESAS_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nomeFantasia = resultSet.getString("nome_fantasia");
                String cnpj = resultSet.getString("cnpj");
                byte[] logo = resultSet.getBytes("logo");
                String slogan = resultSet.getString("slogan");
                Integer idEndereco = resultSet.getInt("id_endereco");
                entity = new Empresa(id, nomeFantasia, cnpj, logo, slogan, idEndereco);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(Empresa entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_EMPRESAS_SQL)) {
            statement.setString(1, entity.getNomeFantasia());
            statement.setString(2, entity.getCnpj());
            statement.setBytes(3, entity.getLogo());
            statement.setString(4, entity.getSlogan());
            statement.setInt(5, entity.getIdEndereco());
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
        try (PreparedStatement statement = prepareSQL(DELETE_EMPRESAS_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_EMPRESAS_SQL)) {
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
