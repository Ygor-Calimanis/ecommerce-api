package com.github.ygorcalimanis.ecommerce.service;

import com.github.ygorcalimanis.ecommerce.model.Pedido;
import com.github.ygorcalimanis.ecommerce.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }
}
