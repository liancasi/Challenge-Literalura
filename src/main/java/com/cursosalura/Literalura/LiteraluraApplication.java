package com.cursosalura.Literalura;

import com.cursosalura.Literalura.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class LiteraluraApplication implements CommandLineRunner {


	@Autowired
	private Principal principal;


	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);
	}
		@Override
	public void run(String... args) throws Exception {
			principal.muestraElMenu();
		}

}
