package com.github.ygorcalimanis.ecommerce.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.github.ygorcalimanis.ecommerce.model.Pedido;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoMapper {
	private final ModelMapper modelMapper;

	public PedidoDTO map(Pedido pedido) {
		PedidoDTO dto = modelMapper.map(pedido, PedidoDTO.class);

		dto.setCliente_id(pedido.getCliente().getId());

		return dto;
	}

}
