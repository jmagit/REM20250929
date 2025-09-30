package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.ioc.anotaciones.Pruebas;

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

	@Async
	public void add() {
		dao.save();
	}
}
