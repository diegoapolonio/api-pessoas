package com.api.pessoasapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name = "/endereco")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank
    @Column
    private String rua;
    @NotBlank
    @Column
    private String logradouro;
    @NotBlank
    @Column
    private String numero;
}
