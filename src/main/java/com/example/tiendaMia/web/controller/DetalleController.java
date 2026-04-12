package com.example.tiendaMia.web.controller;

import com.example.tiendaMia.dominio.dto.DetalleDto;
import com.example.tiendaMia.dominio.service.DetalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalle")
public class DetalleController {
    private final DetalleService detalleService;
    public DetalleController(DetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @PostMapping
    public ResponseEntity<DetalleDto> save(DetalleDto detalleDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.save(detalleDto));
    }
}
