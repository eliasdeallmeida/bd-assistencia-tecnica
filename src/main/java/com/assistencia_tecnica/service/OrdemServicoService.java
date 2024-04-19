package com.assistencia_tecnica.service;

import com.assistencia_tecnica.dao.OrdemServicoDAO;
import com.assistencia_tecnica.model.OrdemServico;

public class OrdemServicoService {

    private OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();

    public void insert(OrdemServico entidade) {
        ordemServicoDAO.insert(entidade);
    }
}
