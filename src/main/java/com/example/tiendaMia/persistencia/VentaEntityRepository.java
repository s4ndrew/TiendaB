package com.example.tiendaMia.persistencia;

import com.example.tiendaMia.dominio.dto.ProductoDto;
import com.example.tiendaMia.dominio.dto.VentaDto;
import com.example.tiendaMia.dominio.repository.ProductoRepository;
import com.example.tiendaMia.dominio.repository.VentaRespository;
import com.example.tiendaMia.persistencia.crud.CrudVentaEntity;
import com.example.tiendaMia.persistencia.entity.VentaEntity;
import com.example.tiendaMia.persistencia.mapper.VentaMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VentaEntityRepository implements VentaRespository {

    private final VentaMapper ventaMapper;
    private final CrudVentaEntity crudVentaEntity;

    public VentaEntityRepository(VentaMapper ventaMapper, CrudVentaEntity crudVentaEntity) {
        this.ventaMapper = ventaMapper;
        this.crudVentaEntity = crudVentaEntity;
    }

    @Override
    public List<VentaDto> getAll() {
        return ventaMapper.toDto(crudVentaEntity.findAll());
    }

    @Override
    public VentaDto save(VentaDto ventaDto) {
        VentaEntity ventaEntity = ventaMapper.toEntity(ventaDto);
        return ventaMapper.toDto(crudVentaEntity.save(ventaEntity));
    }

}
