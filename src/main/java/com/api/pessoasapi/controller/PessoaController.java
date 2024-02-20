package com.api.pessoasapi.controller;

import com.api.pessoasapi.dto.PessoaDto;
import com.api.pessoasapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDto> listarPessoas() {
       return pessoaService.listaDePessoas();
    }
    @GetMapping("/{id}")
    public PessoaDto buscarPessoaId(@PathVariable Long id){
        return pessoaService.buscarPessoaId(id);
    }

    @PostMapping
    public PessoaDto cadastrarPessoa(@RequestBody PessoaDto pessoasDto){
        return pessoaService.cadastrarPessoa(pessoasDto);
    }

    @PutMapping("/{id}")
    public PessoaDto atualizarPessoa(@PathVariable Long id , @RequestBody PessoaDto pessoasDto){
        return pessoaService.atualizarpessoa(id, pessoasDto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPesssoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
    }
    @GetMapping("/buscarPorNome")
    public PessoaDto buscarPorNome(@RequestParam(name = "nome") String nome) {
        return pessoaService.buscarPorNome(nome);
    }


}
