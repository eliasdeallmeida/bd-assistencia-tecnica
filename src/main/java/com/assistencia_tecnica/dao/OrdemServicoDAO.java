package com.assistencia_tecnica.dao;

import com.assistencia_tecnica.model.OrdemServico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO extends DBConnection {

    private static final String INSERT_ORDENS_SERVICO_SQL = "INSERT INTO ordens_servico (observacao, username_responsavel, data_abertura, data_saida, id_cliente, id_empresa) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_ORDENS_SERVICO_SQL = "SELECT * FROM ordens_servico;";
    private static final String SELECT_ORDENS_SERVICO_SQL = "SELECT id, observacao, username_responsavel, data_abertura, data_saida, id_cliente, id_empresa FROM ordens_servico WHERE id = ?";
    private static final String UPDATE_ORDENS_SERVICO_SQL = "UPDATE ordens_servico SET observacao = ?, username_responsavel = ?, data_abertura = ?, data_saida = ?, id_cliente = ?, id_empresa = ? WHERE id = ?;";
    private static final String DELETE_ORDENS_SERVICO_SQL = "DELETE FROM ordens_servico WHERE id = ?;";
    private static final String COUNT_ORDENS_SERVICO_SQL = "SELECT count(1) FROM ordens_servico;";

    public void insert(OrdemServico entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ORDENS_SERVICO_SQL)) {
            preparedStatement.setString(1, entity.getObservacao());
            preparedStatement.setString(2, entity.getUsernameResponsavel());
            preparedStatement.setTimestamp(3, entity.getDataAbertura());
            preparedStatement.setTimestamp(4, entity.getDataSaida());
            preparedStatement.setInt(5, entity.getIdCliente());
            preparedStatement.setInt(6, entity.getIdEmpresa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<OrdemServico> selectAll() {
        List<OrdemServico> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ORDENS_SERVICO_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String observacao = resultSet.getString("observacao");
                String usernameResponsavel = resultSet.getString("username_responsavel");
                Timestamp dataAbertura = resultSet.getTimestamp("data_abertura");
                Timestamp dataSaida = resultSet.getTimestamp("data_saida");
                Integer idCliente = resultSet.getInt("id_cliente");
                Integer idEmpresa = resultSet.getInt("id_empresa");
                entities.add(new OrdemServico(id, observacao, usernameResponsavel, dataAbertura, dataSaida, idCliente, idEmpresa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public OrdemServico select(int id) {
        OrdemServico entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ORDENS_SERVICO_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String observacao = resultSet.getString("observacao");
                String usernameResponsavel = resultSet.getString("username_responsavel");
                Timestamp dataAbertura = resultSet.getTimestamp("data_abertura");
                Timestamp dataSaida = resultSet.getTimestamp("data_saida");
                Integer idCliente = resultSet.getInt("id_cliente");
                Integer idEmpresa = resultSet.getInt("id_empresa");
                entity = new OrdemServico(id, observacao, usernameResponsavel, dataAbertura, dataSaida, idCliente, idEmpresa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(OrdemServico entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_ORDENS_SERVICO_SQL)) {
            statement.setString(1, entity.getObservacao());
            statement.setString(2, entity.getUsernameResponsavel());
            statement.setTimestamp(3, entity.getDataAbertura());
            statement.setTimestamp(4, entity.getDataSaida());
            statement.setInt(5, entity.getIdCliente());
            statement.setInt(6, entity.getIdEmpresa());
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
        try (PreparedStatement statement = prepareSQL(DELETE_ORDENS_SERVICO_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_ORDENS_SERVICO_SQL)) {
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
