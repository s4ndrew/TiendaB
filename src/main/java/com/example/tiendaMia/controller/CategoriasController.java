package com.example.tiendaMia.controller;

import com.example.tiendaMia.persistencia.entity.CategoriaEntity;
import com.example.tiendaMia.persistencia.service.ServiceCategoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    private final ServiceCategoria serviceCategoria;

    public CategoriasController(ServiceCategoria serviceCategoria) {
        this.serviceCategoria = serviceCategoria;
    }

    @PostMapping("/guardarCategoria")
    public ResponseEntity<CategoriaEntity> add(@RequestBody CategoriaEntity categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.serviceCategoria.guardarCategoria(categoria));
    }

    @GetMapping()
    public ResponseEntity<Iterable<CategoriaEntity>> list(CategoriaEntity categoria){
        return ResponseEntity.ok(serviceCategoria.lisCategorias(categoria));
    }


}
