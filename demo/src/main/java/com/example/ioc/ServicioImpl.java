package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
//@Qualifier("prod")
@Profile("default")
public class ServicioImpl implements Servicio {
	private Repositorio dao;
	
	public ServicioImpl(/*@Qualifier("prod")*/ Repositorio dao) {
		this.dao = dao;
	}

	public void add() {
		dao.save();
	}
}
