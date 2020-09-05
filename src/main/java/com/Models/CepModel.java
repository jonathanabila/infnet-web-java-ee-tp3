package com.Models;

public class CepModel {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String siafi;

    public String getStreet() {
        return this.logradouro;
    }

    public String getNeighborhood() {
        return this.bairro;
    }

    public String getCity() {
        return this.localidade;
    }

    public String getState() {
        return this.uf;
    }

    public String getIBGE() {
        return this.siafi;
    }
}
