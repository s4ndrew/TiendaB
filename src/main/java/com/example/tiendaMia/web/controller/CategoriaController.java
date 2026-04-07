package com.example.tiendaMia.web.controller;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService serviceCategoria;

    public CategoriaController(CategoriaService serviceCategoria) {
        this.serviceCategoria = serviceCategoria;
    }

    /*
    @PostMapping("/guardarCategoria")
    public ResponseEntity<CategoriaEntity> add(@RequestBody CategoriaEntity categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.serviceCategoria.guardarCategoria(categoria));
    }
    */
    @GetMapping()
    public ResponseEntity<List<CategoriaDto>> getAll(){
        return ResponseEntity.ok(serviceCategoria.getAll());
    }

}
