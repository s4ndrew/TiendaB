package com.example.tiendaMia.dominio.repository;

import com.example.tiendaMia.dominio.dto.CategoriaDto;

import java.util.List;

public interface CategoriaRepository {
    List<CategoriaDto> getAll();
    CategoriaDto save(CategoriaDto categoriaDto);
}
