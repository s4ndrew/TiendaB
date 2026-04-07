package com.example.tiendaMia.dominio.service;

import com.example.tiendaMia.dominio.dto.CategoriaDto;
import com.example.tiendaMia.dominio.repository.CategoriaRepository;
import com.example.tiendaMia.persistencia.crud.CrudCategoriaEntity;
import com.example.tiendaMia.persistencia.entity.CategoriaEntity;
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

    /*
    private final CrudCategoriaEntity categoriaEntityRepository;

    public CategoriaService(CrudCategoriaEntity categoriaEntityRepository) {
        this.categoriaEntityRepository = categoriaEntityRepository;
    }


    public CategoriaEntity guardarCategoria(CategoriaEntity categoria){
        return categoriaEntityRepository.save(categoria);
    }

    public Iterable<CategoriaEntity> lisCategorias(CategoriaEntity categoria){
        return categoriaEntityRepository.findAll();
    }
     */
}
