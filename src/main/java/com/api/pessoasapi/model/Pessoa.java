package com.api.pessoasapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
@Data
@Entity
@Table(name = "pessoas")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @Column(unique = true)
    private String email;

    @Column(length = 11, nullable = false,unique = true)
    private String cpf;


    @Column(length = 9, nullable = false,unique = true )
    private String rg;


    @Column
    private LocalDate dataDeNascimento;

    private int idade;


    public Integer getIdade() {
        if (dataDeNascimento != null) {
            LocalDate dataAtual = LocalDate.now();
            return Period.between(dataDeNascimento, dataAtual).getYears();
        } else {
            return null;
        }

    }
}

