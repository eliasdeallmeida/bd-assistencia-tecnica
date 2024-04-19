package com.assistencia_tecnica.service;

import com.assistencia_tecnica.dao.EmpresaDAO;
import com.assistencia_tecnica.model.Empresa;

public class EmpresaService {

    private EmpresaDAO empresaDAO = new EmpresaDAO();

    public void insert(Empresa entidade) {
        empresaDAO.insert(entidade);
    }
}
