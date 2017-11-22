package com.puffinpowered.tasktodo.service;

import com.puffinpowered.tasktodo.domain.Todo;
import com.puffinpowered.tasktodo.exception.Detail;
import com.puffinpowered.tasktodo.exception.Message;
import com.puffinpowered.tasktodo.exception.ResourceNotFoundException;
import com.puffinpowered.tasktodo.exception.ValidationError;
import com.puffinpowered.tasktodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepository;
	private ValidationService validationService;

	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository, ValidationService validationService) {
		this.todoRepository = todoRepository;
		this.validationService = validationService;
	}

	@Override
	public Todo createItem(Todo newItem) {
		Boolean isInputValid = validationService.validate(newItem.getText());
		if (isInputValid == Boolean.FALSE) {
			throw validationService.buildValidationError(newItem.getText(), "text");
		} else {
			newItem.setIsCompleted(Boolean.FALSE);
			newItem.setCreatedAt(LocalDateTime.now());
			return todoRepository.save(newItem);
		}
	}

	@Override
	public Todo fetchItem(Long id) {
		    Todo todo = todoRepository.findOne(id);
		    if (todo == null){
			   String message = "Item with "+id+" not found";
		    	throw new ResourceNotFoundException(message);
		    }
		return todo;
	}

	/**
	 * Give the option to only update part of the item
	 * @param id
	 * @param newDetails
	 * @return  the updated item
	 */
	@Override
	public Todo updateItem(Long id, Todo newDetails) {
		Todo todo = todoRepository.findOne(id);
		 if (newDetails != null) {
		 	if (newDetails.getIsCompleted() != null) {
		 		todo.setIsCompleted(newDetails.getIsCompleted());
		    }
		    if (newDetails.getText() != null & !StringUtils.isEmpty(newDetails.getText())){
		 		todo.setText(newDetails.getText());
		    }
		 }
		return todoRepository.save(todo);
	}




}
