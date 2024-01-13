package com.api.pessoasapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
@Data
@Entity
@Table(name = "/pessoas")
public class Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(length = 11, nullable = false,unique = true)
    private String cpf;

    @NotBlank
    @Column(length = 9, nullable = false,unique = true )
    private String rg;

    @NotBlank
    @Column
    private LocalDate dataDeNascimento;

    @Transient
    @NotBlank
    @Column
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

