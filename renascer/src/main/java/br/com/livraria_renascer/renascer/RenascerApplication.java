package br.com.livraria_renascer.renascer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class RenascerApplication {

	public static void main(String[] args) {

		SpringApplication.run(RenascerApplication.class, args);
	}

}
