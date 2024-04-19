package com.assistencia_tecnica.service;

import com.assistencia_tecnica.dao.EnderecoDAO;
import com.assistencia_tecnica.model.Endereco;

public class EnderecoService {

    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    public void insert(Endereco entidade) {
        enderecoDAO.insert(entidade);
    }
}
