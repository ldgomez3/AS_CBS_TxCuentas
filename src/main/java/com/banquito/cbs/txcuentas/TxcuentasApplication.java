package com.banquito.cbs.txcuentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class TxcuentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TxcuentasApplication.class, args);
	}

}
