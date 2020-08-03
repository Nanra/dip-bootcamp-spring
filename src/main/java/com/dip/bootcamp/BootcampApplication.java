package com.dip.bootcamp;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

}
