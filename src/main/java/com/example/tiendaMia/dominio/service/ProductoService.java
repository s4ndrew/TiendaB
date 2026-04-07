package com.example.tiendaMia.dominio.service;

import com.example.tiendaMia.dominio.dto.ProductoDto;
import com.example.tiendaMia.dominio.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDto> getAll(){
        return  productoRepository.getAll();
    }

    /*
    private final CrudProductosEntity crudProductosEntity;

    public ProductoService(CrudProductosEntity crudProductosEntity) {
        this.crudProductosEntity = crudProductosEntity;
    }

    public ProductoEntity save(ProductoEntity producto){
        return crudProductosEntity.save(producto);
    }

    public Iterable<ProductoEntity> getAll(){
        return  crudProductosEntity.findAll();
    }

     */
}
