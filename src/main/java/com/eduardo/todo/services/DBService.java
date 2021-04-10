package com.eduardo.todo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.todo.domain.Todo;
import com.eduardo.todo.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void instanciaBaseDeDados() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11", LocalDate.parse("25/03/2022 10:50", formatter), false);
		
		Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal", LocalDate.parse("22/03/2022 10:50", formatter), true);
		
		Todo t3 = new Todo(null, "Exercícios", "Praticar exercício físico", LocalDate.parse("21/03/2022 10:50", formatter), false);
		
		Todo t4 = new Todo(null, "Meditar", "Meditar durante 30 minutos pela manhã", LocalDate.parse("27/03/2022 10:50", formatter), true);

		todoRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
	}

}
