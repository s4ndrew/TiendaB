package com.example.tiendaMia.dominio.dto.updateDto;

public record UpdateProductoDto(
        String nombre,
        String marca,
        Double precio,
        Integer stock
) {

}
