package com.example.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.aop.anotations.Logged;
import com.example.aop.anotations.LoggerAll;

@Configuration
@ComponentScan("com.example.ioc")
public class IoCConfig {
	@Bean
	String version() {
		return "1.2.0";
	}
	@Bean
	String autor() {
		return "Yo mismo";
	}
	@Bean
	Config cfg() {
		return new Config() {
			
			@Override
			public void configura() {
				System.out.println("Esto se crea al vuelo");
			}
		};
	}
	
	@LoggerAll
	public int getValor() { return 10; }
}
