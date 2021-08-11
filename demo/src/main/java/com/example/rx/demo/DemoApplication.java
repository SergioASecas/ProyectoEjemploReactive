package com.example.rx.demo;

import com.example.rx.demo.Model.Catalogo;
import com.example.rx.demo.Model.Producto;
import com.example.rx.demo.Repository.CatalogoRepository;
import com.example.rx.demo.Repository.ProductoRepository;
import com.example.rx.demo.Service.IProductoService;

import org.hibernate.boot.model.relational.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.var;
import reactor.core.publisher.Flux;

@SpringBootApplication
@RequiredArgsConstructor
@EnableR2dbcRepositories(basePackageClasses = ProductoRepository.class)
public class DemoApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
	
	private final IProductoService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var electronic = new Catalogo("electronic");
		var sport = new Catalogo("sport");
		var computation = new Catalogo("computation");
		var furniture = new Catalogo("furniture");

		Flux.just(electronic, sport, computation, furniture)
			.flatMap(service::saveCategory)
			.doOnNext(x->LOGGER.info(String.format("Insert category: %s with Id: %s", x.getNombre(), x.getId() ))).
			thenMany(
				Flux.just(
					new Producto("TV Panasonic", 456.89 , electronic),
					new Producto("Sony Camara HD Digital", 177.89, electronic),
					new Producto("Sony Notebook", 46.89, computation),
					new Producto("Bianchi Bicicleta", 70.89, sport),
					new Producto("Mica Cómoda 5 cajones", 150.89, furniture)
				)).flatMap(service::saveProduct)
				.subscribe(x->LOGGER.info(String.format("Insert product: %s with Id: %s", x.getNombre(), x.getId())));
	}

	/*
	@Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

        return initializer;
    }*/

	/*@Bean
	ApplicationRunner init(DatabaseClient client){
		return ejemplo ->{
			//client.insert("S");
			
		};

	}*/

	

}
