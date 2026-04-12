package com.example.tiendaMia.dominio.repository;

import com.example.tiendaMia.dominio.dto.DetalleDto;

import java.util.List;

public interface DetalleRepository {
    DetalleDto save(DetalleDto detalleDto);
    List<DetalleDto> get();
}
