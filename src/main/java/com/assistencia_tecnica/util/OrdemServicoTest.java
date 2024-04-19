package com.assistencia_tecnica.util;

import com.assistencia_tecnica.dao.OrdemServicoDAO;
import com.assistencia_tecnica.model.OrdemServico;
import com.assistencia_tecnica.service.OrdemServicoService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public class OrdemServicoTest {

    public static void main(String[] args) throws SQLException, ParseException {

        OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
        OrdemServicoService ordemServicoService = new OrdemServicoService();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        OrdemServico ordemServico = new OrdemServico("Observação", "Beltrano", now, 1, 1);

        // Count
        System.out.println(ordemServicoDAO.count());
        System.out.println();

        // Insert
        ordemServicoService.insert(ordemServico);
        System.out.println();

        // Select all
        List<OrdemServico> ordemServicos = ordemServicoDAO.selectAll();
        ordemServicos.forEach(System.out::println);
        System.out.println();

        // Select
        ordemServico = ordemServicoDAO.select(1);
        System.out.println(ordemServico);
        System.out.println();

        // Update
        ordemServico = ordemServicoDAO.select(5);
        ordemServico.setObservacao("Observação 1");
        ordemServico.setUsernameResponsavel("Beltrano de Tal");
        ordemServicoDAO.update(ordemServico);
        ordemServico = ordemServicoDAO.select(5);
        System.out.println(ordemServico);
        System.out.println();

        // Delete
        ordemServicoDAO.delete(35);
        ordemServicoDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
