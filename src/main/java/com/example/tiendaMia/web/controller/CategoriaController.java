package com.example.tiendaMia.web.controller;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateCatDto;
import com.example.tiendaMia.dominio.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService serviceCategoria;

    public CategoriaController(CategoriaService serviceCategoria) {
        this.serviceCategoria = serviceCategoria;
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAll(){
        return ResponseEntity.ok(serviceCategoria.getAll());
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto categoriaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceCategoria.save(categoriaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        serviceCategoria.delete(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Integer id, @RequestBody @Validated UpdateCatDto updateCategoriaDto){
        return ResponseEntity.ok(serviceCategoria.update(id,updateCategoriaDto));
    }
}
