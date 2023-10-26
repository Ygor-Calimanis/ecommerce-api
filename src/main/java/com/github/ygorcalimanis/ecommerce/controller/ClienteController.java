package com.github.ygorcalimanis.ecommerce.controller;

import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        // mapear/converter cada Cliente -> ClienteDTO
        List<ClienteDTO> result =
                clienteService.getAll()
                        .stream()
                        .map(this::map)
                        .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
        // payload
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClienteDTO> findById(long id) {
        if (!clienteService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        ClienteDTO dto = this.map(clienteService.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid ClienteCreateDTO requestDto) {
        Cliente cliente = map(requestDto);

        Cliente clienteSaved = clienteService.save(cliente);

        ClienteDTO responseDto = this.map(clienteSaved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    private Cliente map(ClienteCreateDTO dto) {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        cliente.setDataCadastro(Instant.now());
        return cliente;
    }

    private ClienteDTO map(@PathVariable Cliente cliente) {
        ClienteDTO dto =
                modelMapper.map(cliente, ClienteDTO.class);
        return dto;
    }
}