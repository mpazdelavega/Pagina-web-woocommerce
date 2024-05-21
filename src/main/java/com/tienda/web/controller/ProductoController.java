package com.tienda.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.web.model.Producto;
import com.tienda.web.service.ProductoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("api/productos")
@RestController
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public Iterable<Producto> list(){
        return productoService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Producto create(@RequestBody Producto producto){
        return productoService.create(producto);
    }
}
