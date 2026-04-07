package com.example.tiendaMia.dominio.dto;

public record ProductoDto(
        Integer idProducto,
        String nombre,
        String marca,
        Double precio,
        Integer stock,
        Integer idCategoria
) {
}
