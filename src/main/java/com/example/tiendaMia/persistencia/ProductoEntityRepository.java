package com.example.tiendaMia.persistencia;

import com.example.tiendaMia.dominio.dto.ProductoDto;
import com.example.tiendaMia.dominio.repository.ProductoRepository;
import com.example.tiendaMia.persistencia.crud.CrudProductoEntity;
import com.example.tiendaMia.persistencia.mapper.ProductoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoEntityRepository implements ProductoRepository {
    private final CrudProductoEntity crudProductoEntity;
    private final ProductoMapper productoMapper;

    public ProductoEntityRepository(CrudProductoEntity crudProductoEntity, ProductoMapper productoMapper) {
        this.crudProductoEntity = crudProductoEntity;
        this.productoMapper = productoMapper;
    }

    @Override
    public List<ProductoDto> getAll() {
        return productoMapper.toDto(crudProductoEntity.findAll());
    }
}
