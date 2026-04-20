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
		List<String> myServices = new ArrayList<>();
		myServices.add("Emergency");
		myServices.add("Rediology");

		Center myCenter = new Center("1","Center number 1","Main Street", myServices
				);

		System.out.println(myCenter);

		myCenter.getServices().add("Pharmacy");
		System.out.println("After adding services: " + myCenter.getServices());
	}


}
