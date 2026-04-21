package com.example.tiendaMia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.tiendaMia"})
@SpringBootApplication
public class TiendaMiaApplication {
    public static void main(String[] args) {
        SpringApplication.run(TiendaMiaApplication.class, args);
    }
}
