package com.api.pessoasapi.service;

import com.api.pessoasapi.configRabbitMQ.QueueSender;
import com.api.pessoasapi.configRabbitMQ.SenderConfig;
import com.api.pessoasapi.dto.PessoaDto;
import com.api.pessoasapi.pessoaMapper.PessoaMapper;
import com.api.pessoasapi.model.Pessoa;
import com.api.pessoasapi.reposirory.PessoaReposirory;
import com.api.pessoasapi.service.exceptions.RecordNotFoundExcepition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaReposirory repositoryPessoas;
    @Autowired
    private PessoaMapper mapperPessoas;
    @Autowired
    private QueueSender queueSender;


    public PessoaDto getPessoaPorNome(String nome) {
        return repositoryPessoas.getPessoaPorNome(nome)
                .map(pessoa ->mapperPessoas.converterParaDto(pessoa) ).orElseThrow(
                        ()->new RecordNotFoundExcepition(nome));
    }

    public List<PessoaDto> listaDePessoas() {
        List<Pessoa> pessoa = repositoryPessoas.findAll();
        return pessoa.stream().
                map(pessoas -> mapperPessoas.converterParaDto(pessoas)).
                collect(Collectors.toList());

    }

    public PessoaDto buscarPessoaId(Long id) {
        return repositoryPessoas.findById(id).
                map(pessoa -> mapperPessoas.converterParaDto(pessoa))
                .orElseThrow(
                ()-> new RecordNotFoundExcepition(id));
    }

    public PessoaDto cadastrarPessoa(PessoaDto pessoasDto) {
        Pessoa pessoas = mapperPessoas.converterParaPessoa(pessoasDto);
        pessoas = repositoryPessoas.save(pessoas);
        queueSender.send(pessoasDto);
        PessoaDto pessoasDto1 = mapperPessoas.converterParaDto(pessoas);
        return pessoasDto1;
    }

    public PessoaDto atualizarpessoa(Long id, PessoaDto pessoasDto) {
        if (repositoryPessoas.existsById(id)) {
            pessoasDto.setId(id);
            Pessoa pessoas = mapperPessoas.converterParaPessoa(pessoasDto);
            pessoas = repositoryPessoas.save(pessoas);
            PessoaDto pessoasDto1 = mapperPessoas.converterParaDto(pessoas);
            return pessoasDto1;
        } else {
            return null;
        }

    }

    public void deletarPessoa(Long id) {
        repositoryPessoas.delete(repositoryPessoas.findById(id)
                .orElseThrow(()->new RecordNotFoundExcepition(id)));
    }
}