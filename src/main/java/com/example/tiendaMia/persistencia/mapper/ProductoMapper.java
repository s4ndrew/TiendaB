package com.example.tiendaMia.persistencia.mapper;

import com.example.tiendaMia.dominio.dto.ProductoDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateProductoDto;
import com.example.tiendaMia.persistencia.entity.ProductoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "categoriaEntity.idCategoria", target = "idCategoria")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "precio", target = "precio")
    @Mapping(source = "marca",target = "marca")
    @Mapping(source = "nombre",target = "nombre")
    //@Mapping(source = "idProducto", target = "idProducto")
    ProductoDto toDto(ProductoEntity productoEntity);
    List<ProductoDto> toDto(Iterable<ProductoEntity> productoEntityIterable);


    @InheritInverseConfiguration
    @Mapping (source = "idCategoria", target = "categoriaEntity.idCategoria")
    ProductoEntity toEntity(ProductoDto productoDto);

    void updateProductoDto(UpdateProductoDto productoDto, @MappingTarget ProductoEntity productoEntity);
}
