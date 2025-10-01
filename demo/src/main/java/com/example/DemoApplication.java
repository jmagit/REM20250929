package com.example;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.aop.AuthenticationService;
import com.example.aop.introductions.Visible;
import com.example.contracts.domain.repositories.ActoresRepository;
import com.example.domain.entities.Actor;
import com.example.ioc.DemoEvent;
import com.example.ioc.Dummy;
import com.example.ioc.IoCConfig;
import com.example.ioc.Rango;
import com.example.ioc.Repositorio;
import com.example.ioc.Servicio;
import com.example.ioc.ServicioImpl;

import jakarta.transaction.Transactional;

@SpringBootApplication
// @EnableScheduling
@EnableAspectJAutoProxy
//@ConfigurationPropertiesScan
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
//	@Qualifier("prod")
	private Servicio srv;
//	@Autowired
//	@Pruebas
//	private Servicio srvTest;
	
	@Value("${info.app.description:Sin descripcion}")
	String cad;
	
	@Autowired(required = false)
	private Rango rango;
	
	@Autowired
	ActoresRepository dao;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada ...");
		
//		System.out.println("Read --------------------------------------");
//		dao.findAll().forEach(System.out::println);
//		System.out.println("Create --------------------------------------");
//		var actor = new Actor(0, "Pepito", "Grillo");
//		var id = dao.save(actor).getActorId();
//		actor = null;
//		dao.findAll().forEach(System.out::println);
//		System.out.println("Update --------------------------------------");
//		var item = dao.findById(id);
//		if(item.isPresent()) {
//			actor = item.get();
//			actor.setFirstName(actor.getFirstName().toUpperCase());
//			dao.save(actor);
//		} else {
//			System.err.println("Actor %d no encontrado.".formatted(id));
//		}
//		dao.findAll().forEach(System.out::println);
//		System.out.println("Delete --------------------------------------");
//		dao.deleteById(id);
//		dao.findAll().forEach(System.out::println);
		
//		dao.findTop10ByFirstNameStartsWithOrderByLastNameDesc("P").forEach(System.out::println);
//		dao.findTop10ByFirstNameStartsWith("P", Sort.by("FirstName").descending()).forEach(System.out::println);
//		dao.findByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.findNuevosJPQL(200).forEach(System.out::println);
//		dao.findNuevosSQL(200).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.greaterThan(root.get("actorId"), 200)).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("actorId"), 200)).forEach(System.out::println);
		
		var item = dao.findById(1);
		if(item.isPresent()) {
			var actor = item.get();
			System.out.println(actor);
			actor.getFilmActors().forEach(fm -> System.out.println(fm.getFilm()));
		} else {
			System.err.println("Actor no encontrado.");
		}

	}
	
//	@Bean
	CommandLineRunner demosAOP(Dummy d1, Dummy d2, AuthenticationService auth) {
		return args -> {
			auth.login();
			srv.add();
			if(srv instanceof Visible v) {
				System.out.println(v.isVisible() ? "Es visible" : "Invisible");
			} else {
				System.out.println("No implementa Visible");
			}
			if(rango != null)
				System.out.println(rango);
			else
				System.out.println("sin rango");
//			srvTest.add();
			System.out.println("Valor config: %d".formatted(d1.getValor()));
			System.out.println("Dummy 2: %s".formatted(d2.getCreate()));
			System.out.println("Dummy 1: %s".formatted(d1.getCreate()));
			d1.setCreate("Modificado");
//			d1.setCreate(null);
//			d1.clearCreate();
//			System.out.println("Dummy 1: %s".formatted(d1.getCreate().toUpperCase()));
			d1.getCreate().ifPresentOrElse(
					s -> System.out.println("Dummy 1: %s".formatted(s.toUpperCase())), 
					() -> System.err.println("Dummy 1 es null")
					);
			System.out.println("Dummy 2: %s".formatted(d2.getCreate()));
		};
	}

	
//	@Bean
//	CommandLineRunner demosIoC(Servicio srv) {
//		return args -> {
//			srv.add();
//			System.err.println(cad);
//			if(rango != null)
//				System.err.println(rango);
//			else
//				System.err.println("sin rango");
////			srvTest.add();
//			
////			Servicio otro = new ServicioImpl(new RepositorioImpl(new ConfigImpl())) ;
////			Servicio otro = new ServicioImpl(new RepositorioMock()) ;
//			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(IoCConfig.class);
//			Servicio otro = new ServicioImpl(ctx.getBean(Repositorio.class)) ;
//	
//			otro.add();
//		};
//	}

	@EventListener
	void receptor(DemoEvent e) {
		System.out.println("Evento inteceptado en DemoApplication -> " + e.tipo());
	}
	
	@Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
	void progamado() {
		System.out.println("Han pasado 5 segundos");
	}
}
