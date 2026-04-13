package com.example.tiendaMia.dominio.dto;

public record ClienteDto(
    Integer idCliente,
    String dni,
    String nombre,
    String apellido,
    String telefono
) {
}
