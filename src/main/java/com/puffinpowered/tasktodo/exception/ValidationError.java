package com.puffinpowered.tasktodo.exception;

import com.puffinpowered.tasktodo.enums.TaskToDoEnum;
import org.springframework.http.HttpStatus;


/**
 * This works in tandem with ValidationResponse and is used by the global
 * RestExceptionHandler controller to identify and provide information to the requester
 * when the request fails validation
 */
public class ValidationError extends RuntimeException{

	String name;

	Detail detail;

	HttpStatus status;

	public ValidationError(Detail detail, String message) {
		super(message);
		this.detail = detail;
		this.name = TaskToDoEnum.VALIDATION_ERROR.value();
		this.status = HttpStatus.BAD_REQUEST;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Detail getDetail() {
		return detail;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
