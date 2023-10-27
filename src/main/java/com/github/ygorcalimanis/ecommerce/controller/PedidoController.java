package com.github.ygorcalimanis.ecommerce.controller;

import com.github.ygorcalimanis.ecommerce.model.Pedido;
import com.github.ygorcalimanis.ecommerce.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {

        List<PedidoDTO> result =
                pedidoService.getAll().stream().map(this::map).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
        // payload
    }

    private PedidoDTO map(Pedido pedido) {
        PedidoDTO dto = modelMapper.map(pedido, PedidoDTO.class);
        dto.setCliente_id(pedido.getCliente().getId());
        return dto;
    }

//    @GetMapping(value = "{id}")
//    public ResponseEntity<ClienteDTO> findById(long id) {
//        if (!clienteService.exists(id)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        ClienteDTO dto = this.map(clienteService.findById(id));
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }
//
//    @PostMapping
//
//    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteCreateDTO requestDto) {
//        Cliente cliente = map(requestDto);
//
//        Cliente clienteSaved = clienteService.save(cliente);
//
//        ClienteDTO responseDto = this.map(clienteSaved);
//        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
//    }
//
//    @PutMapping("{id}")
//
//    public ResponseEntity<ClienteDTO> update(@Valid @RequestBody ClienteCreateDTO requestDto, @PathVariable long id) {
//        if (!clienteService.exists(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        Cliente cliente = map(requestDto);
//
//        cliente.setId(id);
//
//        Cliente clienteSaved = clienteService.save(cliente);
//
//        ClienteDTO responseDto = this.map(clienteSaved);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    private Cliente map(ClienteCreateDTO dto) {
//        Cliente cliente = modelMapper.map(dto, Cliente.class);
//        cliente.setDataCadastro(Instant.now());
//        return cliente;
//    }
//
//    private ClienteDTO map(@PathVariable Cliente cliente) {
//        ClienteDTO dto =
//                modelMapper.map(cliente, ClienteDTO.class);
//        return dto;
//    }
}