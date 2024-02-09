package com.api.pessoasapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class EnderecoDto implements Serializable {

    private long id;

    @NotBlank
    private String rua;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String numero;


}
