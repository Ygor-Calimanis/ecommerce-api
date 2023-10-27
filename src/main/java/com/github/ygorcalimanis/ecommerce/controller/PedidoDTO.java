package com.github.ygorcalimanis.ecommerce.controller;

import com.github.ygorcalimanis.ecommerce.model.Cliente;
import com.github.ygorcalimanis.ecommerce.model.SituacaoPedido;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class PedidoDTO {

    private Long id;

    private Long cliente_id;

    private Instant dataPedido;

    private Instant dataEntrega;

    private BigDecimal valorTotal;

    private SituacaoPedido situacao;
}
