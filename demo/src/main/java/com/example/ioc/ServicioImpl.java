package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class ServicioImpl implements Servicio {
	private Repositorio dao;
	
	public ServicioImpl(Repositorio dao) {
		this.dao = dao;
	}
	
	@PostConstruct
	private void inti() {
		
	}

	public void add() {
		dao.save();
	}
}
