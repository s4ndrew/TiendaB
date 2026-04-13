package com.example.tiendaMia.persistencia.mapper;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateCatDto;
import com.example.tiendaMia.persistencia.entity.CategoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(source = "idCategoria",target = "idCategoria")
    @Mapping(source = "nombre",target = "nombre")
    CategoriaDto toDto(CategoriaEntity entity);
    List<CategoriaDto> toDto(Iterable<CategoriaEntity> categoriaEntityList);

    @InheritInverseConfiguration
    CategoriaEntity toEntity(CategoriaDto categoriaDto);


    //update
    void updateCategoriaDto(UpdateCatDto updateCategoriaDto, @MappingTarget CategoriaEntity categoriaEntity);
}
