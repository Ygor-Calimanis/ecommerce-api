package com.github.ygorcalimanis.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.github.ygorcalimanis.ecommerce.model.Pedido;
import com.github.ygorcalimanis.ecommerce.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.ygorcalimanis.ecommerce.model.Cliente;
import com.github.ygorcalimanis.ecommerce.service.ClienteService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
	private final ClienteService clienteService;
	private final PedidoService pedidoService;
	private final ClienteMapper clienteMapper;
	private final PedidoMapper pedidoMapper;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {

		// mapear/converter cada Cliente -> ClienteDTO
		List<ClienteDTO> result = clienteService.getAll().stream().map(clienteMapper::map).collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable long id) {
		if (!clienteService.exists(id)) {
			return ResponseEntity.notFound().build();
		}

		ClienteDTO dto = clienteMapper.map(clienteService.findById(id));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("{id}/pedidos")
	public ResponseEntity<List<PedidoDTO>> findPedidosByClienteId(@PathVariable long id) {
		if (!clienteService.exists(id)) {
			return ResponseEntity.notFound().build();
		}

		List<PedidoDTO> dto = pedidoService.findByCliente(id).stream().map(pedidoMapper::map).collect(Collectors.toList());

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteCreateDTO requestDto) {

		Cliente cliente = clienteMapper.map(requestDto);

		Cliente clienteSaved = clienteService.save(cliente);

		ClienteDTO responseDto = clienteMapper.map(clienteSaved);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}
}