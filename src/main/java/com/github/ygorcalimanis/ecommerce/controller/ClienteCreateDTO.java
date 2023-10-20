package com.github.ygorcalimanis.ecommerce.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteCreateDTO {
    private String nome;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private boolean ativo;
}
