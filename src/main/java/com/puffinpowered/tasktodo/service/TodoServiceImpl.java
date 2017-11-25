package com.puffinpowered.tasktodo.service;

import com.puffinpowered.tasktodo.domain.Todo;
import com.puffinpowered.tasktodo.exception.ResourceNotFoundException;
import com.puffinpowered.tasktodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Boolean isInputValid = validationService.validateText(newItem.getText());
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
			Todo  todo = this.fetchItem(id);
			if (newDetails != null) {
				if (newDetails.getIsCompleted() != null) {
					Boolean isInputValid = validationService.validateIsComplete(newDetails.getIsCompleted());
					todo.setIsCompleted(newDetails.getIsCompleted());
				}
				if (newDetails.getText() != null ) {
					Boolean isInputValid = validationService.validateText(newDetails.getText());
					if (isInputValid == Boolean.FALSE) {
						throw validationService.buildValidationError(newDetails.getText(), "text");
					}
					todo.setText(newDetails.getText());
				}
				todoRepository.save(todo);
			}
//			}
		return  todo;
	}




}
