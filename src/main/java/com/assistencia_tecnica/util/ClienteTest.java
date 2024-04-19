package com.assistencia_tecnica.util;

import com.assistencia_tecnica.dao.ClienteDAO;
import com.assistencia_tecnica.model.Cliente;
import com.assistencia_tecnica.service.ClienteService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ClienteTest {

    public static void main(String[] args) throws SQLException, ParseException {

        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteService clienteService = new ClienteService();
        Cliente cliente = new Cliente("Fulano", "54927482165", "fulano@gmail.com", Date.valueOf("2000-05-10"), 1);

        // Count
        System.out.println(clienteDAO.count());
        System.out.println();

        // Insert
        clienteService.insert(cliente);
        System.out.println();

        // Select all
        List<Cliente> clientes = clienteDAO.selectAll();
        clientes.forEach(System.out::println);
        System.out.println();

        // Select
        cliente = clienteDAO.select(1);
        System.out.println(cliente);
        System.out.println();

        // Update
        cliente = clienteDAO.select(1);
        cliente.setNome("Fulano de Tal");
        cliente.setCpf("91287398127");
        // cliente.setId(1);
        clienteDAO.update(cliente);
        cliente = clienteDAO.select(1);
        System.out.println(cliente);
        System.out.println();

        // Delete
        clienteDAO.delete(35);
        clienteDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
