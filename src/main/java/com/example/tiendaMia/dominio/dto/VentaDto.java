package com.example.tiendaMia.dominio.dto;

import java.time.LocalDate;

public record VentaDto(
        Integer idVenta,
        LocalDate fecha,
        Double total,
        Integer idCliente
) {
}
