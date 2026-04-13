package com.example.tiendaMia.web.controller;

import com.example.tiendaMia.dominio.dto.ProductoDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateProductoDto;
import com.example.tiendaMia.dominio.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /*
    @PostMapping("/nuevoProducto")
    public ResponseEntity<ProductoEntity> save(@RequestBody ProductoEntity producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceProductos.save(producto));
    }

     */

    @GetMapping
    public  ResponseEntity<List<ProductoDto>> get(){
        return ResponseEntity.ok(productoService.getAll());
    }

    @PostMapping
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto productoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(productoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        productoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> update(@PathVariable Integer id, @RequestBody @Validated UpdateProductoDto updateProductoDto){
       return ResponseEntity.ok( productoService.update(id, updateProductoDto));
    }
}
