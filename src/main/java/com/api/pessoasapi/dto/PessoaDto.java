package com.api.pessoasapi.dto;

import com.api.pessoasapi.model.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaDto implements Serializable {

    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    private EnderecoDto endereco;
    @NotBlank
    private String email;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

}