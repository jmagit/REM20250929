package com.example.ioc;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorioImpl implements Repositorio {
	@Override
	public void save() {
		System.out.println("Guardo en la bd.");
	}
}
