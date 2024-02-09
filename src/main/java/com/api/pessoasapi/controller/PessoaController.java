package com.api.pessoasapi.controller;

import com.api.pessoasapi.dto.PessoaDto;
import com.api.pessoasapi.model.Pessoa;
import com.api.pessoasapi.service.PessoaService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
//@Api(value = "API REST de cadastro pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
   // @ApiOperation(value = "Retorna uma Lista de Pessoa")
    public List<PessoaDto> listarPessoas() {
       return pessoaService.listaDePessoas();
    }
    @GetMapping("/{id}")
  //  @ApiOperation(value = "Buscar Pessoa por Id")
    public PessoaDto buscarPessoaId(@PathVariable Long id){
        return pessoaService.buscarPessoaId(id);
    }

    @PostMapping
  // @ApiOperation(value = "Cadrastrar Pessoa")
    public PessoaDto cadastrarPessoa(@RequestBody PessoaDto pessoasDto){
        return pessoaService.cadastrarPessoa(pessoasDto);
    }

    @PutMapping("/{id}")
  //  @ApiOperation(value = "Atualizar Pessoa")
    public PessoaDto atualizarPessoa(@PathVariable Long id , @RequestBody PessoaDto pessoasDto){
        return pessoaService.atualizarpessoa(id, pessoasDto);
    }
    @DeleteMapping("/{id}")
   // @ApiOperation(value ="Deletar pessoa")
    public void deletarPesssoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
    }
    @GetMapping("/buscarPorNome")
    public PessoaDto buscarPorNome(@RequestParam String nome) {
        return pessoaService.PessoaPorNome(nome);
    }


}
