package com.api.pessoasapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name = "enderecos")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Endereco implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private String rua;
    @Column
    private String logradouro;
    @Column
    private String numero;
}
