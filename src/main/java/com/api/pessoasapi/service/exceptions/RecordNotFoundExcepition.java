package com.api.pessoasapi.service.exceptions;

public class RecordNotFoundExcepition extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundExcepition(long id) {
        super("Registro não encontrado"+id);
    }
    public RecordNotFoundExcepition(String nome){
        super("Usuario não encontrado"+nome);
    }
}