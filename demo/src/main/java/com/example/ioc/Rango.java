package com.example.ioc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Value;

//@Component
//@ConfigurationProperties("rango")
@Value
public class Rango {
	int min;
	int max;
}

//public record Rango(int min, int max) {}
