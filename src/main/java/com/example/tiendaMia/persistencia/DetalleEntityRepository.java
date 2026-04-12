package com.example.tiendaMia.persistencia;

import com.example.tiendaMia.dominio.dto.DetalleDto;
import com.example.tiendaMia.dominio.repository.DetalleRepository;
import com.example.tiendaMia.persistencia.crud.CrudDetalleEntity;
import com.example.tiendaMia.persistencia.entity.DetalleEntity;
import com.example.tiendaMia.persistencia.mapper.DetalleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetalleEntityRepository implements DetalleRepository {
    private final DetalleMapper detalleMapper;
    private final CrudDetalleEntity crudDetalleEntity;

    public DetalleEntityRepository(DetalleMapper detalleMapper, CrudDetalleEntity crudDetalleEntity) {
        this.detalleMapper = detalleMapper;
        this.crudDetalleEntity = crudDetalleEntity;
    }

    @Override
    public DetalleDto save(DetalleDto detalleDto) {
        DetalleEntity detalleEntity = detalleMapper.toEntity(detalleDto);
        crudDetalleEntity.save(detalleEntity);
        return detalleMapper.toDto(detalleEntity);
    }

    @Override
    public List<DetalleDto> get() {
        return List.of();
    }
}
