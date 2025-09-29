package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
//@Primary
@Pruebas
public class RepositorioMock implements Repositorio {
	@Autowired
	private Config cfg;
	
	public RepositorioMock() {
		// se precipita
		// config.configura();
	}
	
	@PostConstruct
	private void inti() {
		cfg.configura();
	}

	@Override
	public void save() {
		System.out.println("Esto es una simulacion");
	}
}
