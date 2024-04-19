package com.assistencia_tecnica.dao;

import com.assistencia_tecnica.model.ItemOrdemServico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemOrdemServicoDAO extends DBConnection {

    private static final String INSERT_ITENS_ORDEM_SERVICO_SQL = "INSERT INTO itens_ordem_servico (descricao, preco, id_ordem_servico) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_ITENS_ORDEM_SERVICO_SQL = "SELECT * FROM itens_ordem_servico;";
    private static final String SELECT_ITENS_ORDEM_SERVICO_SQL = "SELECT id, descricao, preco, id_ordem_servico FROM itens_ordem_servico WHERE id = ?";
    private static final String UPDATE_ITENS_ORDEM_SERVICO_SQL = "UPDATE itens_ordem_servico SET descricao = ?, preco = ?, id_ordem_servico = ? WHERE id = ?;";
    private static final String DELETE_ITENS_ORDEM_SERVICO_SQL = "DELETE FROM itens_ordem_servico WHERE id = ?;";
    private static final String COUNT_ITENS_ORDEM_SERVICO_SQL = "SELECT count(1) FROM itens_ordem_servico;";

    public void insert(ItemOrdemServico entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ITENS_ORDEM_SERVICO_SQL)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setLong(2, entity.getPreco());
            preparedStatement.setInt(3, entity.getIdOrdemServico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItemOrdemServico> selectAll() {
        List<ItemOrdemServico> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ITENS_ORDEM_SERVICO_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                Long preco = resultSet.getLong("preco");
                Integer idOrdemServico = resultSet.getInt("id_ordem_servico");
                entities.add(new ItemOrdemServico(id, descricao, preco, idOrdemServico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public ItemOrdemServico select(int id) {
        ItemOrdemServico entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ITENS_ORDEM_SERVICO_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                Long preco = resultSet.getLong("preco");
                Integer idOrdemServico = resultSet.getInt("id_ordem_servico");
                entity = new ItemOrdemServico(id, descricao, preco, idOrdemServico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(ItemOrdemServico entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_ITENS_ORDEM_SERVICO_SQL)) {
            statement.setString(1, entity.getDescricao());
            statement.setLong(2, entity.getPreco());
            statement.setInt(3, entity.getIdOrdemServico());
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
        try (PreparedStatement statement = prepareSQL(DELETE_ITENS_ORDEM_SERVICO_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_ITENS_ORDEM_SERVICO_SQL)) {
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
