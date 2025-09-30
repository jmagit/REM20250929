package com.example.ioc;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.aop.anotations.LoggerAll;
import com.example.aop.anotations.Logging;

@Component
@Scope("prototype")
public class Dummy {
	private String create = LocalDateTime.now().toString();
	
	@LoggerAll
	public int getValor() { return 10; }

//	public String getCreate() {
//		return create;
//	}
	public Optional<String> getCreate() {
		return Optional.ofNullable(create);
	}
	
	public void setCreate(String value) {
		create = value;
	}
	
	@Logging
	public void clearCreate() {
		create = null;
	}
	

}
