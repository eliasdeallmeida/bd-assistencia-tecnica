package com.assistencia_tecnica.util;

import com.assistencia_tecnica.dao.UFDAO;
import com.assistencia_tecnica.model.UF;
import com.assistencia_tecnica.service.UFService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class UFTest {

    public static void main(String[] args) throws SQLException, ParseException {

        UFDAO ufDAO = new UFDAO();
        UFService ufService = new UFService();
        UF uf = new UF("São Paulo", 10);

        // Count
        System.out.println(ufDAO.count());
        System.out.println();

        // Insert
        ufService.insert(uf);
        System.out.println();

        // Select all
        List<UF> ufs = ufDAO.selectAll();
        ufs.forEach(System.out::println);
        System.out.println();

        // Select
        uf = ufDAO.select(1);
        System.out.println(uf);
        System.out.println();

        // Update
        uf = ufDAO.select(1);
        uf.setDescricao("Ceará");
        uf.setCodigo(10);
        ufDAO.update(uf);
        uf = ufDAO.select(1);
        System.out.println(uf);
        System.out.println();

        // Delete
        ufDAO.delete(35);
        ufDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
