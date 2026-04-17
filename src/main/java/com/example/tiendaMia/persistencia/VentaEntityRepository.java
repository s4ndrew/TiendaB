package com.example.tiendaMia.persistencia;
import com.example.tiendaMia.dominio.dto.VentaDto;
import com.example.tiendaMia.dominio.repository.VentaRespository;
import com.example.tiendaMia.persistencia.crud.CrudDetalleEntity;
import com.example.tiendaMia.persistencia.crud.CrudVentaEntity;
import com.example.tiendaMia.persistencia.entity.DetalleEntity;
import com.example.tiendaMia.persistencia.entity.VentaEntity;
import com.example.tiendaMia.persistencia.mapper.VentaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VentaEntityRepository implements VentaRespository {

    private final VentaMapper ventaMapper;
    private final CrudVentaEntity crudVentaEntity;
    private final CrudDetalleEntity crudDetalleEntity;

    public VentaEntityRepository(VentaMapper ventaMapper, CrudVentaEntity crudVentaEntity, CrudDetalleEntity crudDetalleEntity) {
        this.ventaMapper = ventaMapper;
        this.crudVentaEntity = crudVentaEntity;
        this.crudDetalleEntity = crudDetalleEntity;
    }

    @Override
    public List<VentaDto> getAll() {
        return ventaMapper.toDto(crudVentaEntity.findAll());
    }

    @Override
    public VentaDto save(VentaDto ventaDto) {
        VentaEntity ventaEntity = ventaMapper.toEntity(ventaDto);

        double sbtotal = 0;

        for (DetalleEntity detalleEntity : ventaEntity.getDetalleEntityList()){
            detalleEntity.setVentaEntity(ventaEntity);
            sbtotal += detalleEntity.getSubtotal();
        }

        ventaEntity.setTotal(sbtotal * 0.8);

        return ventaMapper.toDto(crudVentaEntity.save(ventaEntity));
    }

}
