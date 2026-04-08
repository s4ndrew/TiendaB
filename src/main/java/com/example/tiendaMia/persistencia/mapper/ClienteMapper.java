package com.example.tiendaMia.persistencia.mapper;

import com.example.tiendaMia.dominio.dto.ClienteDto;
import com.example.tiendaMia.persistencia.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    //@Mapping(source = "telefono",target = "telefono")
    //@Mapping(source = "apellido",target = "apellido")
    //@Mapping(source = "nombre", target = "nombre")
    //@Mapping(source = "dni", target = "dni")
    @Mapping(source = "idCliente", target = "id")
    ClienteDto toDto(ClienteEntity clienteEntity);
    List<ClienteDto> toDto(List<ClienteEntity> clienteEntities);

    @InheritInverseConfiguration
    @Mapping(target = "idCliente", ignore = true )
    ClienteEntity toEntity(ClienteDto clienteDto);

}
