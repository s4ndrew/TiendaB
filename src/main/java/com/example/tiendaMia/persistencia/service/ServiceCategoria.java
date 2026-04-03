package com.example.tiendaMia.persistencia.service;

import com.example.tiendaMia.persistencia.crud.CrudCategoriaEntity;
import com.example.tiendaMia.persistencia.entity.CategoriaEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceCategoria {

    private final CrudCategoriaEntity categoriaEntityRepository;

    public ServiceCategoria(CrudCategoriaEntity categoriaEntityRepository) {
        this.categoriaEntityRepository = categoriaEntityRepository;
    }


    public CategoriaEntity guardarCategoria(CategoriaEntity categoria){
        return categoriaEntityRepository.save(categoria);
    }

    public Iterable<CategoriaEntity> lisCategorias(CategoriaEntity categoria){
        return categoriaEntityRepository.findAll();
    }
}
