package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.aop.anotations.Logged;

import jakarta.annotation.PostConstruct;

@Service
//@Qualifier("prod")
@Profile("default")
public class ServicioImpl implements Servicio {
	private Repositorio dao;
	
	public ServicioImpl(/*@Qualifier("prod")*/ Repositorio dao) {
		this.dao = dao;
	}

	@Async
	@Logged
	public void add() {
		dao.save();
		otro();
	}
	public void otro() {
		dao.save();
	}

}
