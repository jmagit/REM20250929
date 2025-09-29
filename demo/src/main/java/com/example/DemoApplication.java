package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.ioc.Pruebas;
import com.example.ioc.Rango;
import com.example.ioc.Servicio;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
//	@Qualifier("prod")
	private Servicio srv;
//	@Autowired
//	@Pruebas
//	private Servicio srvTest;
	
	@Value("${info.app.description:Sin descripcion}")
	String cad;
	
//	@Autowired(required = false)
	private Rango rango;
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada ...");
		
		srv.add();
		System.err.println(cad);
		if(rango != null)
			System.err.println(rango);
		else
			System.err.println("sin rango");
//		srvTest.add();
		
//		Servicio otro = new ServicioImpl(new RepositorioImpl(new ConfigImpl())) ;
//		Servicio otro = new ServicioImpl(new RepositorioMock()) ;
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		Servicio otro = new ServicioImpl(ctx.getBean(Repositorio.class)) ;
//
//		otro.add();
	}

}
