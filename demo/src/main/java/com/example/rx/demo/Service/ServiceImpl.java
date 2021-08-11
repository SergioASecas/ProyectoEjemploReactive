package com.example.rx.demo.Service;

import com.example.rx.demo.Model.Catalogo;
import com.example.rx.demo.Model.Producto;
import com.example.rx.demo.Repository.CatalogoRepository;
import com.example.rx.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements IProductoService {

    @Autowired
    public ProductoRepository productoRepository;

    @Autowired
    private CatalogoRepository catalogoRepository;


    @Override
    @Transactional(readOnly = true)
    public Flux<Producto> findAllProducts() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<Catalogo> findAllCatalogos() {
        return catalogoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
        public Flux<Producto> findAllProductsWithUpperCase() {
        return productoRepository.findAll().map(x -> {
            x.setNombre(x.getNombre().toUpperCase());
            return x;
        });
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Producto> findProductbyId(String id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Mono<Producto> saveProduct(Producto producto) {
        return  productoRepository.save(producto);
    }

    @Override
    @Transactional
    public Mono<Catalogo> saveCategory(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    @Override
    @Transactional
    public Mono<Void> deleteProduct(Producto producto) {
        return productoRepository.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Producto> findProductbyName(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Catalogo> findByCategoryNombre(String nombre) {
        return catalogoRepository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Catalogo> findCatalogobyId(String id) {
        return catalogoRepository.findById(id);
    }
}
