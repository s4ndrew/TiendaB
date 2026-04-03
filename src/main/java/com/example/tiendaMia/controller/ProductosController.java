package com.example.tiendaMia.controller;

import com.example.tiendaMia.persistencia.entity.ProductoEntity;
import com.example.tiendaMia.persistencia.service.ServiceCategoria;
import com.example.tiendaMia.persistencia.service.ServiceProductos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    private final ServiceProductos serviceProductos;

    public ProductosController(ServiceProductos serviceProductos) {
        this.serviceProductos = serviceProductos;
    }

    @PostMapping("/nuevoProducto")
    public ResponseEntity<ProductoEntity> save(@RequestBody ProductoEntity producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceProductos.save(producto));
    }

    @GetMapping
    public  ResponseEntity<Iterable<ProductoEntity>> get(ProductoEntity producto){
        return ResponseEntity.ok(serviceProductos.getAll(producto));
    }
}
