package com.puffinpowered.tasktodo.controller;

import com.puffinpowered.tasktodo.domain.BalanceTestResult;
import com.puffinpowered.tasktodo.domain.Todo;
import com.puffinpowered.tasktodo.exception.ValidationError;
import com.puffinpowered.tasktodo.service.TodoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

	TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<Todo> create(@RequestBody Todo newItem) throws ValidationError {
		Todo item = todoService.createItem(newItem);
		return new ResponseEntity<Todo>(item, HttpStatus.OK);
	}


	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Todo> show(@PathVariable(value = "id") Long id) throws ValidationError {
		Todo item = todoService.fetchItem(id) ;
		return new ResponseEntity<Todo>(item, HttpStatus.OK);
	}


	@RequestMapping(value="/{id}", method={RequestMethod.PATCH, RequestMethod.PUT})
	public ResponseEntity<Todo> update(@PathVariable(value = "id") Long id, @RequestParam(value = "input") Todo input) throws ValidationError {
		Todo item = todoService.updateItem(id, input) ;
		return new ResponseEntity<Todo>(item, HttpStatus.OK);
	}


}
