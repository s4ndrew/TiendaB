package com.example.tiendaMia.persistencia.crud;

import com.example.tiendaMia.persistencia.entity.DetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudDetalleEntity extends JpaRepository<DetalleEntity,Integer> {
}
