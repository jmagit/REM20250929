package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
@Primary
public class RepositorioMock implements Repositorio {
	@Autowired
	private Config config;
	
	public RepositorioMock() {
		// se precipita
		// config.configura();
	}
	
	@PostConstruct
	private void inti() {
		config.configura();
	}

	@Override
	public void save() {
		System.out.println("Esto es una simulacion");
	}
}
