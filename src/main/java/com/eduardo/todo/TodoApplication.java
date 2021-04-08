package com.eduardo.todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eduardo.todo.domain.Todo;
import com.eduardo.todo.repositories.TodoRepository;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",LocalDate.parse("25/03/2022 10:50", formatter), false);
		
		todoRepository.saveAll(Arrays.asList(t1));
	}

}
