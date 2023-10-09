package com.github.ygorcalimanis.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.ygorcalimanis.ecommerce.model.Cliente;
import com.github.ygorcalimanis.ecommerce.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	} 
	
}