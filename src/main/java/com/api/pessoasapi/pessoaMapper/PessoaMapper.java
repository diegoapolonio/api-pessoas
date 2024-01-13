package com.api.pessoasapi.pessoaMapper;

import com.api.pessoasapi.dto.PessoaDto;
import com.api.pessoasapi.model.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
@Component
public class PessoaMapper {

    private ObjectMapper objectMapper = new ObjectMapper();

    public PessoaDto converterParaDto(Pessoa pessoas) {
        PessoaDto pessoasDto = objectMapper.convertValue(pessoas, PessoaDto.class);
        return pessoasDto;
    }
    public Pessoa converterParaPessoa(PessoaDto pessoasDto){
        Pessoa pessoas = objectMapper.convertValue(pessoasDto, Pessoa.class);
        return pessoas;
    }
}
