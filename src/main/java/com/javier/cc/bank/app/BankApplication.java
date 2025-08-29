package com.javier.cc.bank.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@Profile("!test") //Run every time EXCEPT Tests
@SpringBootApplication
@ComponentScan(value = "com.javier.cc.bank.repositories , com.javier.cc.bank.models") //No leía las clases de estos paquetes.
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}



}
