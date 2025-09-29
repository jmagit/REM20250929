package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("prod")
public class RepositorioImpl implements Repositorio {
	private Config config;
	
	public RepositorioImpl(Config config) {
		this.config = config;
		config.configura();
	}

	@Override
	public void save() {
		System.out.println("Guardo en la bd.");
	}
}
