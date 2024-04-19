package com.assistencia_tecnica.util;

import com.assistencia_tecnica.dao.ItemOrdemServicoDAO;
import com.assistencia_tecnica.model.ItemOrdemServico;
import com.assistencia_tecnica.service.ItemOrdemServicoService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ItemOrdemServicoTest {

    public static void main(String[] args) throws SQLException, ParseException {

        ItemOrdemServicoDAO itemOrdemServicoDAO = new ItemOrdemServicoDAO();
        ItemOrdemServicoService itemOrdemServicoService = new ItemOrdemServicoService();
        ItemOrdemServico itemOrdemServico = new ItemOrdemServico("Conserto", 200l, 1);

        // Count
        System.out.println(itemOrdemServicoDAO.count());
        System.out.println();

        // Insert
        itemOrdemServicoService.insert(itemOrdemServico);
        System.out.println();

        // Select all
        List<ItemOrdemServico> itensOrdemServico = itemOrdemServicoDAO.selectAll();
        itensOrdemServico.forEach(System.out::println);
        System.out.println();

        // Select
        itemOrdemServico = itemOrdemServicoDAO.select(1);
        System.out.println(itemOrdemServico);
        System.out.println();

        // Update
        itemOrdemServico = itemOrdemServicoDAO.select(1);
        itemOrdemServico.setDescricao("Conserto contra-baixo");
        itemOrdemServico.setPreco(200l);
        itemOrdemServico.setId(1);
        itemOrdemServicoDAO.update(itemOrdemServico);
        itemOrdemServico = itemOrdemServicoDAO.select(1);
        System.out.println(itemOrdemServico);
        System.out.println();

        // Delete
        itemOrdemServicoDAO.delete(35);
        itemOrdemServicoDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
