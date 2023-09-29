package com.github.ygorcalimanis.ecommerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @Column(nullable = false)
    private Instant dataPedido;

    @Column(nullable = false)
    private Instant dataEntrega;

    @Column
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private SituacaoPedido situacao;
}
