package com.example.tiendaMia.dominio.dto.updateDto;

public record UpdateClienteDto(
    String dni,
    String nombre,
    String apellido,
    String telefono
) {
}
