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

    public Producto create(Producto producto){
        return productoRepository.save(producto);
    }


}
