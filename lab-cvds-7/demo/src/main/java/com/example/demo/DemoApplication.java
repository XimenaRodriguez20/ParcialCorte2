package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {

			employeeService.deleteAllEmployee();

			System.out.println("Adding employees....\n");
			employeeService.addEmployee(new Employee("Ximena", "Rodriguez", "Estudiante", 0, LocalDate.of(2002, 9, 20)));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Profesor", 43000.00, LocalDate.of(1975,4,15)));


			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));


		};
	}

}




