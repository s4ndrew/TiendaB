package com.example.tiendaMia.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "ventas")
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_venta")
    private Integer idVenta;
    private LocalDate fecha;
    private Double total;

    @OneToMany(mappedBy = "ventaEntity")
    private List<DetalleEntity> detalleEntityList;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity clienteEntity;
}
