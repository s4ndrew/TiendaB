package com.example.tiendaMia.persistencia.crud;

import com.example.tiendaMia.persistencia.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudProductoEntity extends CrudRepository<ProductoEntity,Integer> {
}
