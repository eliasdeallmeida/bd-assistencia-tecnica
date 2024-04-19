package com.assistencia_tecnica.model;

public class ItemOrdemServico extends GenericModel {

    private String descricao;
    private Long preco;
    private Integer idOrdemServico;

    public ItemOrdemServico(String descricao, Long preco, Integer idOrdemServico) {
        this.descricao = descricao;
        this.preco = preco;
        this.idOrdemServico = idOrdemServico;
    }

    public ItemOrdemServico(Integer id, String descricao, Long preco, Integer idOrdemServico) {
        this.descricao = descricao;
        this.preco = preco;
        this.idOrdemServico = idOrdemServico;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    public Integer getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(Integer idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    @Override
    public String toString() {
        return String.format("ItemOrdemServico {id = %d, descricao = %s, preco = %d, id_uf = %d}", this.getId(), descricao, preco, idOrdemServico);
    }
}
