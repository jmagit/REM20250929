package com.example.ioc;

import org.springframework.stereotype.Component;

@Component
public class ConfigImpl implements Config {
	@Override
	public void configura() {
		System.out.println("Me configuro");
	}
}
