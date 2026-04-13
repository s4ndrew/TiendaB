package com.example.tiendaMia.persistencia.mapper;

import com.example.tiendaMia.dominio.dto.DetalleDto;
import com.example.tiendaMia.persistencia.entity.DetalleEntity;
import com.example.tiendaMia.persistencia.entity.ProductoEntity;
import com.example.tiendaMia.persistencia.entity.VentaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleMapper {
    @Mapping(source = "ventaEntity.idVenta", target = "idVenta")
    @Mapping(source = "productoEntity.idProducto", target = "idProducto")
    DetalleDto toDto(DetalleEntity detalleEntity);
    List<DetalleDto> toDto(List<DetalleEntity> detalleEntityList);

    @InheritInverseConfiguration
    @Mapping(source = "idVenta", target = "ventaEntity",qualifiedByName = "mapVenta")
    @Mapping(source = "idProducto", target = "productoEntity",qualifiedByName = "mapProducto")
    DetalleEntity toEntity(DetalleDto detalleDto);

    @Named("mapVenta")
    default VentaEntity mapVenta(Integer idVenta){
        if (idVenta == null) return null;
        VentaEntity ventaEntity = new VentaEntity();
        ventaEntity.setIdVenta(idVenta);
        return ventaEntity;
    }
    @Named("mapProducto")
    default ProductoEntity mapProducto(Integer idProducto){
        if (idProducto == null) return null;
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setIdProducto(idProducto);
        return  productoEntity;
    }
}
