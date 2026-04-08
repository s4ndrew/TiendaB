package com.example.tiendaMia.web.controller;

import com.example.tiendaMia.dominio.dto.ClienteDto;
import com.example.tiendaMia.dominio.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto clienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteDto));
    }
}
