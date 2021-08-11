package com.example.rx.demo.Model;

import java.time.LocalDateTime;
import javax.persistence.Id;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("Producto")
public class Producto {

    @Id
    private String id;
    private String nombre;
    private Double precio;
    private LocalDateTime fecha;
    private String foto;
    private Catalogo catalogo;

    public Producto(String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = LocalDateTime.now();
    }

    public Producto(String nombre, Double precio, Catalogo catalogo){
        this.nombre = nombre;
        this.precio = precio;
        this.catalogo = catalogo;
    }

}
