package com.assistencia_tecnica.service;

import com.assistencia_tecnica.dao.ClienteDAO;
import com.assistencia_tecnica.model.Cliente;

public class ClienteService {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public void insert(Cliente entidade) {
        clienteDAO.insert(entidade);
    }
}
