package com.eduardo.todo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eduardo.todo.domain.Todo;
import com.eduardo.todo.services.TodoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

	@Autowired
	private TodoService service;

	@ApiOperation("Busca ToDo pelo Id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		Todo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation("Busca todos os ToDo abertos")
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> listOpen() {

		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation("Busca todos os ToDo encerrados")
	@GetMapping(value = "/close")
	public ResponseEntity<List<Todo>> listClose() {

		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);

	}

	@ApiOperation("Busca todos os ToDo")
	@GetMapping
	public ResponseEntity<List<Todo>> listAll() {
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation("Cria um novo item ToDo")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Item ToDo criado com sucesso!"),
			@ApiResponse(code = 500, message = "Ocorreu um erro!"),
			})
	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody Todo obj) {
		obj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@ApiOperation("Delete um item Todo pelo Id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@ApiOperation("Atualiza um item Todo pelo Id")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj) {

		Todo newObj = service.update(id, obj);

		return ResponseEntity.ok().body(newObj);
	}

}
