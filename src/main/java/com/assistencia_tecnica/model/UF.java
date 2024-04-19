package com.assistencia_tecnica.model;

public class UF extends GenericModel {

    private String descricao;
    private Integer codigo;

    public UF(String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public UF(Integer id, String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return String.format("UF {id = %d, descricao = %s, codigo = %d}", this.getId(), descricao, codigo);
    }
}
