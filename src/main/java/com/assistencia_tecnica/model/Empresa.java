package com.assistencia_tecnica.model;

public class Empresa extends GenericModel {

    private String nomeFantasia;
    private String cnpj;
    private byte[] logo;
    private String slogan;
    private Integer idEndereco;

    public Empresa(String nomeFantasia, String cnpj, Integer idEndereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.idEndereco = idEndereco;
    }

    public Empresa(String nomeFantasia, String cnpj, byte[] logo, Integer idEndereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.logo = logo;
        this.idEndereco = idEndereco;
    }

    public Empresa(String nomeFantasia, String cnpj, String slogan, Integer idEndereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.slogan = slogan;
        this.idEndereco = idEndereco;
    }

    public Empresa(String nomeFantasia, String cnpj, byte logo[], String slogan, Integer idEndereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.logo = logo;
        this.slogan = slogan;
        this.idEndereco = idEndereco;
    }

    public Empresa(Integer id, String nomeFantasia, String cnpj, byte logo[], String slogan, Integer idEndereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.logo = logo;
        this.slogan = slogan;
        this.idEndereco = idEndereco;
        super.setId(id);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdUf(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return String.format("Empresa {id = %d, nome_fantasia = %s, cnpj = %s, logo = %s, slogan = %s, id_uf = %d}", this.getId(), nomeFantasia, cnpj, new String(logo), slogan, idEndereco);
    }
}
