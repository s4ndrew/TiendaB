package com.example.tiendaMia.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_producto", unique = true)
    private Integer idProducto;
    @Column(unique = true)
    private String nombre;
    private String marca;
    private Double precio;
    private Integer stock;
    //Relacion
    @ManyToOne
    private CategoriaEntity categoriaEntity;
}
