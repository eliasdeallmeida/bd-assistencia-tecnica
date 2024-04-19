package com.assistencia_tecnica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    private static final String dbName = "assistencia_tecnica";
    private static final String dbURL = "jdbc:postgresql://localhost:5432/";
    private static final String username = "postgres";
    private static final String password = "123";

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(dbURL.concat(dbName), username, password);
        if (connection == null) {
            throw new RuntimeException("Ops! Erro ao conectar com o banco de dados.");
        }
        System.out.println("Conexão com o banco de dados efetuada com sucesso!");
        return connection;
    }

    public static PreparedStatement prepareSQL(String sql) throws SQLException, ClassNotFoundException {
        return connect().prepareStatement(sql);
    }

    public void printSQLException(SQLException exception) {
        for (Throwable e : exception) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("Estado do SQL: " + ((SQLException) e).getSQLState());
                System.err.println("Codigo do ERRO: " + ((SQLException) e).getErrorCode());
                System.err.println("Messagem: " + e.getMessage());
                Throwable throwable = exception.getCause();
                while (throwable != null) {
                    System.out.println("Causa: " + throwable);
                    throwable = throwable.getCause();
                }
            }
        }
    }
}
