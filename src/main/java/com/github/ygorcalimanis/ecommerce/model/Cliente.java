package com.github.ygorcalimanis.ecommerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@Entity

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 9)
    private String cep;

    @Column(length = 100)
    private String logradouro;

    @Column(length = 10)
    private String numero;

    @Column(length = 20)
    private String complemento;

    @Column(length = 60)
    private String bairro;

    @Column(length = 60)
    private String municipio;

    @Column(length = 2)
    private String uf;

    @Column(nullable = false)
    private Instant dataCadastro;

    @Column(nullable = false)
    private boolean ativo;
}