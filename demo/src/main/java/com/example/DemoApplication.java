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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.aop.AuthenticationService;
import com.example.aop.introductions.Visible;
import com.example.ioc.DemoEvent;
import com.example.ioc.Dummy;
import com.example.ioc.IoCConfig;
import com.example.ioc.Rango;
import com.example.ioc.Repositorio;
import com.example.ioc.Servicio;
import com.example.ioc.ServicioImpl;

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
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada ...");
		
	}
	
	@Bean
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
	CommandLineRunner demosIoC(Servicio srv) {
		return args -> {
			srv.add();
			System.err.println(cad);
			if(rango != null)
				System.err.println(rango);
			else
				System.err.println("sin rango");
//			srvTest.add();
			
//			Servicio otro = new ServicioImpl(new RepositorioImpl(new ConfigImpl())) ;
//			Servicio otro = new ServicioImpl(new RepositorioMock()) ;
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(IoCConfig.class);
			Servicio otro = new ServicioImpl(ctx.getBean(Repositorio.class)) ;
	
			otro.add();
		};
	}

	@EventListener
	void receptor(DemoEvent e) {
		System.out.println("Evento inteceptado en DemoApplication -> " + e.tipo());
	}
	
	@Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
	void progamado() {
		System.out.println("Han pasado 5 segundos");
	}
}
