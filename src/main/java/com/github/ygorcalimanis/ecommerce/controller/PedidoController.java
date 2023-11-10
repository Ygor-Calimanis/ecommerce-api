package com.github.ygorcalimanis.ecommerce.controller;


import com.github.ygorcalimanis.ecommerce.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
	private final PedidoService pedidoService;
	private final PedidoMapper pedidoMapper;

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> getAll() {

		List<PedidoDTO> result =
				pedidoService.getAll()
				.stream()
				.map(pedidoMapper::map)
				.collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}