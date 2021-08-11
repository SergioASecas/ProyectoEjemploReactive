package com.example.rx.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@org.springframework.data.relational.core.mapping.Table("Catalogo")
public class Catalogo {
        
    @Id
    private String id;

    private String nombre;

    public Catalogo(String nombre){
        this.nombre = nombre;
    }
   
}