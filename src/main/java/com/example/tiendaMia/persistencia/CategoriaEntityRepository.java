package com.example.tiendaMia.persistencia;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.repository.CategoriaRepository;
import com.example.tiendaMia.persistencia.crud.CrudCategoriaEntity;
import com.example.tiendaMia.persistencia.mapper.CategoriaMapper;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaEntityRepository implements CategoriaRepository {

    private final CrudCategoriaEntity crudCategoriaEntity;
    private final CategoriaMapper categoriaMapper;

    public CategoriaEntityRepository(CrudCategoriaEntity crudCategoriaEntity, CategoriaMapper categoriaMapper) {
        this.crudCategoriaEntity = crudCategoriaEntity;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public List<CategoriaDto> getAll() {
        return categoriaMapper.toDto(crudCategoriaEntity.findAll());
    }
}
