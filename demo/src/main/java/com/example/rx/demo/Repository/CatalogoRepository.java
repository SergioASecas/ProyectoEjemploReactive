package com.example.rx.demo.Repository;

import com.example.rx.demo.Model.Catalogo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface CatalogoRepository extends ReactiveCrudRepository<Catalogo, String>{

    Mono<Catalogo> findByNombre(String nombre);
}
