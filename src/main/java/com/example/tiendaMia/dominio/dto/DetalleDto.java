package com.example.tiendaMia.dominio.dto;

public record DetalleDto(
        Integer idDetalle,
        Integer cantidad,
        Double precioUnitario,
        Double subtotal,
        Integer idVenta,
        Integer idProducto
) {
}
