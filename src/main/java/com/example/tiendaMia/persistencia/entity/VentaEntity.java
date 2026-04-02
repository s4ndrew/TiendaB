package com.example.tiendaMia.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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

    @OneToMany(mappedBy = "venta")
    private List<DetalleEntity> detalleEntityList;

    @ManyToOne
    private ClienteEntity clienteEntity;
}
