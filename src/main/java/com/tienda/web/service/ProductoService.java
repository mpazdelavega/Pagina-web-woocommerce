package com.tienda.web.service;

import org.springframework.stereotype.Service;

import com.tienda.web.model.Producto;
import com.tienda.web.repository.ProductoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Iterable<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(Integer id){
        return productoRepository
                .findById(id)
                .orElse(null);
    }

    public Producto create(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto update(Integer id, Producto form){
        
        Producto productoDb = findById(id);

        productoDb.setNombre(form.getNombre());
        productoDb.setCantidad(form.getCantidad());

        return productoRepository.save(productoDb);
    }

    public void delete(Integer id){
        
        Producto productoDb = findById(id);

        productoRepository.delete(productoDb);
    }


}
