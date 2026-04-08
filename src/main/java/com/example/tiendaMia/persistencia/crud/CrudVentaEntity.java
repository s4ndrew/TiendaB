package com.example.tiendaMia.persistencia.crud;

import com.example.tiendaMia.persistencia.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudVentaEntity extends JpaRepository<VentaEntity, Integer> {
}
