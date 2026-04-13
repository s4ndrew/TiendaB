package com.example.tiendaMia.web.controller;

import com.example.tiendaMia.dominio.dto.DetalleDto;
import com.example.tiendaMia.dominio.service.DetalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle")
public class DetalleController {
    private final DetalleService detalleService;
    public DetalleController(DetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @PostMapping
    public ResponseEntity<DetalleDto> save(@RequestBody DetalleDto detalleDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.save(detalleDto));
    }

    @GetMapping
    public ResponseEntity<List<DetalleDto>> get(){
        return ResponseEntity.ok(detalleService.getAll());
    }
}
