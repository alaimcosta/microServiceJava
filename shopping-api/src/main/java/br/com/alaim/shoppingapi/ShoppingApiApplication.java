package br.com.alaim.shoppingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class ShoppingApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppingApiApplication.class, args);
	}

}
