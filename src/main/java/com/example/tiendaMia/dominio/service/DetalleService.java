package com.example.tiendaMia.dominio.service;

import com.example.tiendaMia.dominio.dto.DetalleDto;
import com.example.tiendaMia.dominio.repository.DetalleRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleService {
    private final DetalleRepository detalleRepository;

    public DetalleService(DetalleRepository detalleRepository) {
        this.detalleRepository = detalleRepository;
    }

    public DetalleDto save(DetalleDto detalleDto){
        return detalleRepository.save(detalleDto);
    }
}
