package com.api.pessoasapi.dto;

public class EnderecoDto {
    public EnderecoDto() {
    }

    public EnderecoDto(String rua, String logradouro, String numero) {
        this.rua = rua;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    private String rua;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    private String logradouro;
    private String numero;
}
