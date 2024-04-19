package com.assistencia_tecnica.service;

import com.assistencia_tecnica.dao.CidadeDAO;
import com.assistencia_tecnica.model.Cidade;

public class CidadeService {

    private CidadeDAO cidadeDAO = new CidadeDAO();

    public void insert(Cidade entidade) {
        cidadeDAO.insert(entidade);
    }
}
