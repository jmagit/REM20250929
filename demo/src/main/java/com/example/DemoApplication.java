package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ioc.Config;
import com.example.ioc.ConfigImpl;
import com.example.ioc.RepositorioImpl;
import com.example.ioc.RepositorioMock;
import com.example.ioc.Servicio;
import com.example.ioc.ServicioImpl;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private Servicio srv;
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada ...");
		
		// srv.add();
		
//		Servicio otro = new ServicioImpl(new RepositorioImpl(new ConfigImpl())) ;
		Servicio otro = new ServicioImpl(new RepositorioMock(new ConfigImpl())) ;
		otro.add();
	}

}
