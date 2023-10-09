package com.github.ygorcalimanis.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.ygorcalimanis.ecommerce.model.Cliente;
import com.github.ygorcalimanis.ecommerce.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
	private final ClienteService clienteService;
	private final ModelMapper modelMapper;

	@GetMapping
	public List<ClienteDTO> getAll() {
		// pegando dados
		List<Cliente> clientes = clienteService.getAll();		
		// mapear/converter cada Cliente -> ClienteDTO		
		List<ClienteDTO> result = clientes
				.stream()
				.map(this::map)
				.collect(Collectors.toList());		
		return result; // payload
	}
	
	private ClienteDTO map(Cliente cliente) {
		ClienteDTO dto = 
				modelMapper.map(cliente, ClienteDTO.class);
		return dto;
	}	
}