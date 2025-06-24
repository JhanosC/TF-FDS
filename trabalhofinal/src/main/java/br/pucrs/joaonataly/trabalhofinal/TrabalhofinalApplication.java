package br.pucrs.joaonataly.trabalhofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.pucrs.joaonataly.trabalhofinal")
public class TrabalhofinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhofinalApplication.class, args);
		System.out.println("=== Servidor iniciado com sucesso ===");
	}

}
