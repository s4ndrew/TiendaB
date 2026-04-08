package com.example.tiendaMia.dominio.repository;

import com.example.tiendaMia.dominio.dto.VentaDto;
import com.example.tiendaMia.persistencia.entity.VentaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


public interface VentaRespository {

    List<VentaDto> getAll();
    VentaDto save(VentaDto ventaDto);
}
