package com.assistencia_tecnica.service;

import com.assistencia_tecnica.dao.UFDAO;
import com.assistencia_tecnica.model.UF;

public class UFService {

    private UFDAO ufDAO = new UFDAO();

    public void insert(UF entidade) {
        ufDAO.insert(entidade);
    }
}
