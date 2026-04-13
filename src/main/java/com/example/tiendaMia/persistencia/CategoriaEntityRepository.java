package com.example.tiendaMia.persistencia;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateCategoriaDto;
import com.example.tiendaMia.dominio.repository.CategoriaRepository;
import com.example.tiendaMia.persistencia.crud.CrudCategoriaEntity;
import com.example.tiendaMia.persistencia.entity.CategoriaEntity;
import com.example.tiendaMia.persistencia.mapper.CategoriaMapper;
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

    @Override
    public CategoriaDto save(CategoriaDto categoriaDto) {
        CategoriaEntity categoriaEntity = categoriaMapper.toEntity(categoriaDto);
        return categoriaMapper.toDto(crudCategoriaEntity.save(categoriaEntity));
    }

    @Override
    public CategoriaDto update(Integer id, UpdateCategoriaDto updateCategoriaDto) {
        CategoriaEntity categoriaEntity = crudCategoriaEntity.findById(id).orElse(null);
        if (categoriaEntity == null){
            return null;
        }
        categoriaMapper.updateCategoriaDto(updateCategoriaDto,categoriaEntity);
        return categoriaMapper.toDto(crudCategoriaEntity.save(categoriaEntity));
    }


    @Override
    public void delete(Integer id) {
        crudCategoriaEntity.deleteById(id);
    }
}
