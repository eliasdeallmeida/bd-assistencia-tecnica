package com.assistencia_tecnica.model;

public class GenericModel {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("GenericModel {id = %d}", id);
    }
}
