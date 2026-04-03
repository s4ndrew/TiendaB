package com.example.tiendaMia.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categorias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_categoria", unique = true)
    private Integer idCategoria;
    @Column(unique = true)
    private String nombre;

    //Relacion
    @OneToMany(mappedBy = "categoriaEntity")
    private List<ProductoEntity> productoEntityList;
}
