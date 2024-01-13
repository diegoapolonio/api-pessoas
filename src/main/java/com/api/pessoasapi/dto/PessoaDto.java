package com.api.pessoasapi.dto;

public class PessoaDto {
    private String nome;
    private long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PessoaDto(String nome, long id){
        this.nome = nome;
        this.id = id;
    }
}
