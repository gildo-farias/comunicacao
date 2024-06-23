package com.comunicacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EnvioDeComunicacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvioDeComunicacaoApplication.class, args);
	}

}
