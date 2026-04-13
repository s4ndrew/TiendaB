package com.example.tiendaMia.dominio.service;

import com.example.tiendaMia.dominio.dto.DetalleDto;
import com.example.tiendaMia.dominio.repository.DetalleRepository;
import com.example.tiendaMia.persistencia.crud.CrudDetalleEntity;
import com.example.tiendaMia.persistencia.entity.DetalleEntity;
import com.example.tiendaMia.persistencia.mapper.DetalleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleService {
    private final DetalleRepository detalleRepository;
    public DetalleService(DetalleRepository detalleRepository, DetalleMapper detalleMapper, CrudDetalleEntity crudDetalleEntity) {
        this.detalleRepository = detalleRepository;
    }

    public DetalleDto save(DetalleDto detalleDto){
        return detalleRepository.save(detalleDto);
    }

    public List<DetalleDto> getAll(){
        return detalleRepository.get();
    }


}
