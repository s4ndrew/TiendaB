package com.example.tiendaMia.dominio.service;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.dto.updateDto.UpdateCategoriaDto;
import com.example.tiendaMia.dominio.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDto> getAll(){
        return categoriaRepository.getAll();
    }

    public CategoriaDto save(CategoriaDto categoriaDto){
        return categoriaRepository.save(categoriaDto);
    }


    public CategoriaDto update(Integer id, UpdateCategoriaDto updateCategoriaDto){
        return categoriaRepository.update(id,updateCategoriaDto);
    }
    public void delete(Integer id){
         categoriaRepository.delete(id);
    }
}
