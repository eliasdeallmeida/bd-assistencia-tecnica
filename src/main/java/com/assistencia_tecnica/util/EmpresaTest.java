package com.assistencia_tecnica.util;

import com.assistencia_tecnica.dao.EmpresaDAO;
import com.assistencia_tecnica.model.Empresa;
import com.assistencia_tecnica.service.EmpresaService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class EmpresaTest {

    public static void main(String[] args) throws SQLException, ParseException {

        EmpresaDAO empresaDAO = new EmpresaDAO();
        EmpresaService empresaService = new EmpresaService();
        Empresa empresa = new Empresa("Empresa", "18723692749438", "logo-image.png".getBytes(), 1);

        // Count
        System.out.println(empresaDAO.count());
        System.out.println();

        // Insert
        empresaService.insert(empresa);
        System.out.println();

        // Select all
        List<Empresa> empresas = empresaDAO.selectAll();
        empresas.forEach(System.out::println);
        System.out.println();

        // Select
        empresa = empresaDAO.select(1);
        System.out.println(empresa);
        System.out.println();

        // Update
        // empresa = empresaDAO.select(1);
        // empresa.setNomeFantasia("Empresa 1");
        // empresa.setCnpj("89374982372494");
        // empresa.setLogo((byte) 123);
        // empresa.setSlogan("Slogan 1");
        // empresa.setId(1);
        // empresaDAO.update(empresa);
        // empresa = empresaDAO.select(1);
        // System.out.println(empresa);
        // System.out.println();

        // Delete
        empresaDAO.delete(35);
        empresaDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
