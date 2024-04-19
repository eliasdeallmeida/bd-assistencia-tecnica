package com.assistencia_tecnica.util;

import com.assistencia_tecnica.dao.CidadeDAO;
import com.assistencia_tecnica.model.Cidade;
import com.assistencia_tecnica.service.CidadeService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CidadeTest {

    public static void main(String[] args) throws SQLException, ParseException {

        CidadeDAO cidadeDAO = new CidadeDAO();
        CidadeService cidadeService = new CidadeService();
        Cidade cidade = new Cidade("São Paulo", 101, 1);

        // Count
        System.out.println(cidadeDAO.count());
        System.out.println();

        // Insert
        cidadeService.insert(cidade);
        System.out.println();

        // Select all
        List<Cidade> cidades = cidadeDAO.selectAll();
        cidades.forEach(System.out::println);
        System.out.println();

        // Select
        cidade = cidadeDAO.select(1);
        System.out.println(cidade);
        System.out.println();

        // Update
        cidade = cidadeDAO.select(1);
        cidade.setDescricao("Fortaleza");
        cidade.setCodigo(101);
        cidade.setId(1);
        cidadeDAO.update(cidade);
        cidade = cidadeDAO.select(1);
        System.out.println(cidade);
        System.out.println();

        // Delete
        cidadeDAO.delete(35);
        cidadeDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
