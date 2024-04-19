package com.assistencia_tecnica.util;

import com.assistencia_tecnica.dao.EnderecoDAO;
import com.assistencia_tecnica.model.Endereco;
import com.assistencia_tecnica.service.EnderecoService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class EnderecoTest {

    public static void main(String[] args) throws SQLException, ParseException {

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        EnderecoService enderecoService = new EnderecoService();
        Endereco endereco = new Endereco("1", "1", "A", "12798371", 1);

        // Count
        System.out.println(enderecoDAO.count());
        System.out.println();

        // Insert
        enderecoService.insert(endereco);
        System.out.println();

        // Select all
        List<Endereco> enderecos = enderecoDAO.selectAll();
        enderecos.forEach(System.out::println);
        System.out.println();

        // Select
        endereco = enderecoDAO.select(1);
        System.out.println(endereco);
        System.out.println();

        // Update
        endereco = enderecoDAO.select(1);
        endereco.setRua("123");
        endereco.setNumero("321");
        endereco.setBairro("Jereissati");
        endereco.setCep("14612927");
        enderecoDAO.update(endereco);
        endereco = enderecoDAO.select(1);
        System.out.println(endereco);
        System.out.println();

        // Delete
        enderecoDAO.delete(35);
        enderecoDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
