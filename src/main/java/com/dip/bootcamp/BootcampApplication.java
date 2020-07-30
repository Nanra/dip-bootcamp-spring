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

		// Instance Model Object
		Employee dataEmployee = new Employee();
		dataEmployee.setId(7);
		dataEmployee.setName("Nanra Sukedy");
		dataEmployee.setEmail("nanrasukedy@outlook.com");
		dataEmployee.setAddress("Bandung");

		// Print Out Data Employee
		System.out.println("Employee Id: " + dataEmployee.getId());
		System.out.println("Employee Name: " + dataEmployee.getName());
		System.out.println("Employee Email: " + dataEmployee.getEmail());
		System.out.println("Employee Address: " + dataEmployee.getAddress());

	}

}
