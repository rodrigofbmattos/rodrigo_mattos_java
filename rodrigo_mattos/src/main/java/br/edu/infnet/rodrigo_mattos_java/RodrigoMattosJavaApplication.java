package br.edu.infnet.rodrigo_mattos_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RodrigoMattosJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RodrigoMattosJavaApplication.class, args);
	}

}
