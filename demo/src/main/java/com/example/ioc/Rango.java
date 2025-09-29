package com.example.ioc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Value;

//@Data
//@Component
//@ConfigurationProperties("rango")
//public class Rango {
//    private int min;
//    private int max;    
//}

@ConfigurationProperties(prefix = "rango")
public record Rango(int min, int max) {}

