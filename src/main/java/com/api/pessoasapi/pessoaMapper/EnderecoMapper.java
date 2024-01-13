package com.api.pessoasapi.pessoaMapper;

import com.api.pessoasapi.dto.EnderecoDto;
import com.api.pessoasapi.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnderecoMapper {

    ObjectMapper objectMapper= new ObjectMapper();

    public EnderecoDto converterEnderecoParaDto(Endereco endereco){
        EnderecoDto enderecoDto= objectMapper.convertValue(endereco, EnderecoDto.class);
        return enderecoDto;
    }
    public Endereco converterEnderecoParaModel(EnderecoDto enderecoDto){
        Endereco endereco= objectMapper.convertValue(enderecoDto, Endereco.class);
        return endereco;
    }
}
