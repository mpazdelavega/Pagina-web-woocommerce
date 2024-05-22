package com.tienda.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("{id}")
    public Producto get(@PathVariable Integer id){
        return productoService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Producto create(@RequestBody Producto producto){
        return productoService.create(producto);
    }

    @PutMapping("{id}")
    public Producto update(@PathVariable Integer id, @RequestBody Producto form){
    
        return productoService.update(id, form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){

        productoService.delete(id);
    }

}
