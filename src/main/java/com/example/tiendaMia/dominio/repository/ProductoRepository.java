package com.example.tiendaMia.dominio.repository;

import com.example.tiendaMia.dominio.dto.ProductoDto;

import java.util.List;

public interface ProductoRepository {
    List<ProductoDto> getAll();
    ProductoDto save(ProductoDto productoDto);
}
