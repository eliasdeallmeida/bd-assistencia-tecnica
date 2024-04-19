package com.assistencia_tecnica.service;

import com.assistencia_tecnica.dao.ItemOrdemServicoDAO;
import com.assistencia_tecnica.model.ItemOrdemServico;

public class ItemOrdemServicoService {

    private ItemOrdemServicoDAO itemOrdemServicoDAO = new ItemOrdemServicoDAO();

    public void insert(ItemOrdemServico entidade) {
        itemOrdemServicoDAO.insert(entidade);
    }
}
