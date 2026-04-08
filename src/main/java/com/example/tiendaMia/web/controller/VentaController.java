package com.example.tiendaMia.web.controller;

import com.example.tiendaMia.dominio.dto.VentaDto;
import com.example.tiendaMia.dominio.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<VentaDto> save(@RequestBody VentaDto ventaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(ventaDto));
    }

    @GetMapping
    public ResponseEntity<List<VentaDto>> get(){
        return ResponseEntity.ok(ventaService.get());
    }
}
