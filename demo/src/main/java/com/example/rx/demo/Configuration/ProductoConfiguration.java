package com.example.rx.demo.Configuration;

import com.example.rx.demo.Repository.ProductoRepository;
import com.example.rx.demo.Service.IProductoService;
import com.example.rx.demo.Service.ServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ProductoConfiguration {

    @Bean
    @Primary
    public IProductoService getBeanProductoService(){
        return new ServiceImpl();
    }
}
