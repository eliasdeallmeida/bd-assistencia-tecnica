package com.assistencia_tecnica.model;

import java.sql.Date;

public class Cliente extends GenericModel {

    private String nome;
    private String cpf;
    private String email;
    private Date dataNascimento;
    private Integer idEndereco;

    public Cliente(String nome, String cpf, String email, Integer idEndereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idEndereco = idEndereco;
    }

    public Cliente(String nome, String cpf, String email, Date dataNascimento, Integer idEndereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.idEndereco = idEndereco;
    }

    public Cliente(Integer id, String nome, String cpf, String email, Date dataNascimento, Integer idEndereco) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.idEndereco = idEndereco;
        super.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return String.format("Cliente {id = %d, nome = %s, cpf = %s, email = %s, data_nascimento = %tF, id_uf = %d}", this.getId(), nome, cpf, email, dataNascimento, idEndereco);
    }
}
