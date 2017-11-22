package com.puffinpowered.tasktodo.exception;

import com.puffinpowered.tasktodo.enums.TaskToDoEnum;
import org.springframework.http.HttpStatus;


/**
 * This works in tandem with ValidationResponse and is used by the global
 * RestExceptionHandler controller to identify and provide information to the requester
 * when the request fails validation
 */
public class ResourceNotFoundException extends RuntimeException{

	String name;

	String message;

	HttpStatus status;

	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
		this.name = TaskToDoEnum.NOT_FOUND.value();
		this.status = HttpStatus.NOT_FOUND;
	}

	public ResourceNotFoundException() {

	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
