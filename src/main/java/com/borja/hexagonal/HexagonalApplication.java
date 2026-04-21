package com.borja.hexagonal;

import com.borja.hexagonal.domain.model.Center;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalApplication.class, args);

		System.out.println("--- La aplicación se ha iniciado correctamente ---");
	}


}
