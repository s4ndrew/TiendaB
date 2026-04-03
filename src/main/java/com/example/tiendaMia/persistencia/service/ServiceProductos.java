package com.example.tiendaMia.persistencia.service;

import com.example.tiendaMia.persistencia.crud.CrudCategoriaEntity;
import com.example.tiendaMia.persistencia.crud.CrudProductosEntity;
import com.example.tiendaMia.persistencia.entity.ProductoEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceProductos {

    private final CrudProductosEntity crudProductosEntity;

    public ServiceProductos(CrudProductosEntity crudProductosEntity) {
        this.crudProductosEntity = crudProductosEntity;
    }

    public ProductoEntity save(ProductoEntity producto){
        return crudProductosEntity.save(producto);
    }

    public Iterable<ProductoEntity> getAll(ProductoEntity producto){
        return  crudProductosEntity.findAll();
    }
}
