package com.example.rx.demo.Service;

import com.example.rx.demo.Model.Catalogo;
import com.example.rx.demo.Model.Producto;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface IProductoService {
    
    Flux<Producto>  findAllProducts();
    Flux<Catalogo>  findAllCatalogos();
    Flux<Producto>  findAllProductsWithUpperCase();
    Mono<Producto>  findProductbyId(String id);
    Mono<Catalogo>  findCatalogobyId(String id);
    Mono<Producto>  saveProduct(Producto producto);
    Mono<Catalogo>  saveCategory(Catalogo catalogo);
    Mono<Void>      deleteProduct(Producto producto);
    Mono<Producto>  findProductbyName(String nombre);
    Mono<Catalogo>  findByCategoryNombre(String nombre);

}
