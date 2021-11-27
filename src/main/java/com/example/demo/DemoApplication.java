package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ManagerRepository managerRepository) {
		return args -> {
			Employee maria = new Employee("Maria Carey");
			Employee john = new Employee("Johny Deep");
			Employee tim = new Employee("Tim Cook");
			List<Employee> employeeList_us = List.of(maria, john, tim);

			Employee tung = new Employee("Tung Hoang");
			Employee huyen = new Employee("Thanh Huyen");
			Employee mai = new Employee("Dieu Mai");
			List<Employee> employeeList_vn = List.of(tung, huyen, mai);

			Manager manager_us = new Manager("manager_us", employeeList_us);
			Manager manager_vn = new Manager("manager_vn", employeeList_vn);
			List<Manager> managerList = List.of(manager_us, manager_vn);

			List<Manager> list = managerRepository.saveAll(managerList);
		};
	}

}
