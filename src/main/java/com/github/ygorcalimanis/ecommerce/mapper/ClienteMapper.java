package com.github.ygorcalimanis.ecommerce.mapper;

import java.time.Instant;

import com.github.ygorcalimanis.ecommerce.dto.ClienteCreateDTO;
import com.github.ygorcalimanis.ecommerce.dto.ClienteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.github.ygorcalimanis.ecommerce.model.Cliente;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteMapper {
	private final ModelMapper modelMapper;

	public Cliente map(ClienteCreateDTO dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.setDataCadastro(Instant.now());
		return cliente;
	}

	public ClienteDTO map(Cliente cliente) {
		ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
		return dto;
	}
}