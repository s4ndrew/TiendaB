package com.example.tiendaMia.dominio.dto;

public record ClienteDto(
    Integer id,
    String dni,
    String nombre,
    String apellido,
    String telefono
) {
}
