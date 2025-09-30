package com.example.ioc;

import org.springframework.stereotype.Component;

@Component("config")
public class ConfigImpl implements Config {
	public ConfigImpl(String version, String autor) {
//		System.out.println("version: %s autor: %s".formatted(version, autor));
	}
	@Override
	public void configura() {
//		System.out.println("Me configuro");
	}
}
