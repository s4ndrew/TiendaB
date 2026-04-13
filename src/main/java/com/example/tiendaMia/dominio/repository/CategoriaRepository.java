package com.example.tiendaMia.dominio.repository;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateCatDto;

import java.util.List;

public interface CategoriaRepository {
    List<CategoriaDto> getAll();
    CategoriaDto save(CategoriaDto categoriaDto);
    CategoriaDto update(Integer id, UpdateCatDto updateCategoriaDto);
    void delete(Integer id);
}
