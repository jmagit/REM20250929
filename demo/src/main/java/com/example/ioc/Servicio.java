package com.example.ioc;

import org.springframework.scheduling.annotation.Async;

public interface Servicio {
	@Async
	void add();
}