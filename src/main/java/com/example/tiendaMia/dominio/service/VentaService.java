package com.example.tiendaMia.dominio.service;

import com.example.tiendaMia.dominio.dto.VentaDto;
import com.example.tiendaMia.dominio.repository.VentaRespository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VentaService {

    private final VentaRespository ventaRespository;

    public VentaService(VentaRespository ventaRespository) {
        this.ventaRespository = ventaRespository;
    }

    //Falta agregar la logica de que el total de la venta es casi el total de detalles
    public VentaDto save(VentaDto ventaDto){
        return ventaRespository.save(ventaDto);
    }

    public List<VentaDto> get(){
        return ventaRespository.getAll();
    }
}
