package com.example.tiendaMia.dominio.repository;

import com.example.tiendaMia.dominio.dto.ProductoDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateProductoDto;

import java.util.List;

public interface ProductoRepository {
    List<ProductoDto> getAll();
    ProductoDto save(ProductoDto productoDto);
    void delete(Integer id);
    ProductoDto update(Integer id, UpdateProductoDto updateProductoDto);
}
