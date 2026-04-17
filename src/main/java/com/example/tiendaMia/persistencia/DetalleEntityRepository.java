package com.example.tiendaMia.persistencia;

import com.example.tiendaMia.dominio.dto.DetalleDto;
import com.example.tiendaMia.dominio.repository.DetalleRepository;
import com.example.tiendaMia.persistencia.crud.CrudDetalleEntity;
import com.example.tiendaMia.persistencia.crud.CrudProductoEntity;
import com.example.tiendaMia.persistencia.crud.CrudVentaEntity;
import com.example.tiendaMia.persistencia.entity.DetalleEntity;
import com.example.tiendaMia.persistencia.entity.ProductoEntity;
import com.example.tiendaMia.persistencia.entity.VentaEntity;
import com.example.tiendaMia.persistencia.mapper.DetalleMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DetalleEntityRepository implements DetalleRepository {
    private final DetalleMapper detalleMapper;
    private final CrudDetalleEntity crudDetalleEntity;
    private  final CrudProductoEntity crudProductoEntity;
    private final CrudVentaEntity crudVentaEntity;

    public DetalleEntityRepository(DetalleMapper detalleMapper, CrudDetalleEntity crudDetalleEntity, CrudProductoEntity crudProductoEntity, CrudVentaEntity crudVentaEntity) {
        this.detalleMapper = detalleMapper;
        this.crudDetalleEntity = crudDetalleEntity;
        this.crudProductoEntity = crudProductoEntity;
        this.crudVentaEntity = crudVentaEntity;
    }

    @Override
    public DetalleDto save(DetalleDto detalleDto) {
        DetalleEntity detalleEntity = detalleMapper.toEntity(detalleDto);
        ProductoEntity productoEntity = crudProductoEntity.findById(detalleDto.idProducto()).orElseThrow(() -> new RuntimeException("Precio no encontrado"));

        detalleEntity.setPrecioUnitario(productoEntity.getPrecio());
        detalleEntity.setSubtotal(detalleEntity.getPrecioUnitario() * detalleEntity.getCantidad()) ;

        
        VentaEntity ventaEntity = crudVentaEntity.findById(detalleDto.idVenta())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        double nuevoSbtotal = 0;
        for (DetalleEntity d : ventaEntity.getDetalleEntityList()) {
            nuevoSbtotal += d.getSubtotal();
        }

        ventaEntity.setTotal(nuevoSbtotal * 0.5);
        crudVentaEntity.save(ventaEntity);

        return detalleMapper.toDto(crudDetalleEntity.save(detalleEntity));
    }

    @Override
    public List<DetalleDto> get() {
        return detalleMapper.toDto(crudDetalleEntity.findAll());
    }
}
