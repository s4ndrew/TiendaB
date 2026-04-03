package com.example.tiendaMia.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cliente", nullable = false, unique = true)
    private Integer idCliente;
    @Column(unique = true)
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;

    @OneToMany(mappedBy = "clienteEntity")
    private List<VentaEntity> ventaEntityList;
}
