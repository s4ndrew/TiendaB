package com.example.tiendaMia.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "detalles_venta")
public class DetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    private Integer cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    private Double subtotal;
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private VentaEntity ventaEntity;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity productoEntity;
}
