package com.assistencia_tecnica.model;

import java.sql.Timestamp;

public class OrdemServico extends GenericModel {

    private String observacao;
    private String usernameResponsavel;
    private Timestamp dataAbertura;
    private Timestamp dataSaida;
    private Integer idCliente;
    private Integer idEmpresa;

    public OrdemServico(String usernameResponsavel, Timestamp dataAbertura, Integer idCliente, Integer idEmpresa) {
        this.usernameResponsavel = usernameResponsavel;
        this.dataAbertura = dataAbertura;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }

    public OrdemServico(String observacao, String usernameResponsavel, Timestamp dataAbertura, Integer idCliente, Integer idEmpresa) {
        this.observacao = observacao;
        this.usernameResponsavel = usernameResponsavel;
        this.dataAbertura = dataAbertura;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }

    public OrdemServico(String usernameResponsavel, Timestamp dataAbertura, Timestamp dataSaida, Integer idCliente, Integer idEmpresa) {
        this.usernameResponsavel = usernameResponsavel;
        this.dataAbertura = dataAbertura;
        this.dataSaida = dataSaida;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }

    public OrdemServico(String observacao, String usernameResponsavel, Timestamp dataAbertura, Timestamp dataSaida, Integer idCliente, Integer idEmpresa) {
        this.observacao = observacao;
        this.usernameResponsavel = usernameResponsavel;
        this.dataAbertura = dataAbertura;
        this.dataSaida = dataSaida;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }

    public OrdemServico(int id, String observacao, String usernameResponsavel, Timestamp dataAbertura, Timestamp dataSaida, Integer idCliente, Integer idEmpresa) {
        this.observacao = observacao;
        this.usernameResponsavel = usernameResponsavel;
        this.dataAbertura = dataAbertura;
        this.dataSaida = dataSaida;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getUsernameResponsavel() {
        return usernameResponsavel;
    }

    public void setUsernameResponsavel(String usernameResponsavel) {
        this.usernameResponsavel = usernameResponsavel;
    }

    public Timestamp getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Timestamp dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Timestamp getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Timestamp dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return String.format("OrdemServico {id = %d, observacao = %s, username_responsavel = %s, data_abertura = %tc, data_saida = %tc, id_cliente = %d, id_empresa = %d}", this.getId(), observacao, usernameResponsavel, dataAbertura, dataSaida, idCliente, idEmpresa);
    }
}
