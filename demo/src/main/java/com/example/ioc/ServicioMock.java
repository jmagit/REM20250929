package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
//@Pruebas
@Profile("test")
public class ServicioMock implements Servicio {
	private Repositorio dao;
	
	@Pruebas
	public ServicioMock(/*@Pruebas*/ Repositorio dao) {
		this.dao = dao;
	}

	public void add() {
		dao.save();
	}
}
