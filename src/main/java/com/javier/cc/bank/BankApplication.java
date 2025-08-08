package com.javier.cc.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@Profile("!test") //Run every time EXCEPT Tests
@SpringBootApplication()
@ComponentScan("com.javier.cc.bank.repositories") //No leía las clases de este paquete.
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
