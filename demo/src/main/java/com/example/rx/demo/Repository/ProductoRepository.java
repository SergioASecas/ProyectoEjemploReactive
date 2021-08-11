package com.example.rx.demo.Repository;

import com.example.rx.demo.Model.Producto;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface ProductoRepository extends ReactiveCrudRepository<Producto,String> {
   
    Mono<Producto> findByNombre(String nombre);
}
