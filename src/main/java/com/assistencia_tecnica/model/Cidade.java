package com.assistencia_tecnica.model;

public class Cidade extends GenericModel {

    private String descricao;
    private Integer codigo;
    private Integer idUf;

    public Cidade(String descricao, Integer codigo, Integer idUf) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.idUf = idUf;
    }

    public Cidade(Integer id, String descricao, Integer codigo, Integer idUf) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.idUf = idUf;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getIdUf() {
        return idUf;
    }

    public void setIdUf(Integer idUf) {
        this.idUf = idUf;
    }

    @Override
    public String toString() {
        return String.format("Cidade {id = %d, descricao = %s, codigo = %d, id_uf = %d}", this.getId(), descricao, codigo, idUf);
    }
}
