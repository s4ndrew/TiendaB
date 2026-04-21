package com.example.tiendaMia.persistencia.mapper;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateCategoriaDto;
import com.example.tiendaMia.persistencia.entity.CategoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CategoriaMapper {
    CategoriaDto toDto(CategoriaEntity entity);
    List<CategoriaDto> toDto(Iterable<CategoriaEntity> categoriaEntityList);

    @InheritInverseConfiguration
    CategoriaEntity toEntity(CategoriaDto categoriaDto);


    //update
    void updateCategoriaDto(UpdateCategoriaDto updateCategoriaDto, @MappingTarget CategoriaEntity categoriaEntity);
}
