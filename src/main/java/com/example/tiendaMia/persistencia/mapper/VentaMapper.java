package com.example.tiendaMia.persistencia.mapper;

import com.example.tiendaMia.dominio.dto.VentaDto;
import com.example.tiendaMia.persistencia.entity.VentaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {ClienteMapper.class})
public interface VentaMapper {

    @Mapping(source = "clienteEntity.idCliente",target = "idCliente")
    VentaDto toDto(VentaEntity ventaEntity);
    List<VentaDto> toDto(List<VentaEntity> ventaEntities);


    @InheritInverseConfiguration
    @Mapping(ignore = true, target = "fecha")
    VentaEntity toEntity(VentaDto ventaDto);
}
