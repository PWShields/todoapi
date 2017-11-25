package com.puffinpowered.tasktodo.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.puffinpowered.tasktodo.exception.ValidationResponse;
import com.puffinpowered.tasktodo.exception.ValidationError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(ValidationError.class)
	protected ResponseEntity<ValidationResponse>handleToDoItemValidationError(ValidationError ex){
	 	ArrayList details = new ArrayList();
	 	details.add(ex.getDetail());
		 ValidationResponse validationResponse = new ValidationResponse(details);
		           return buildResponseEntity(validationResponse, ex.getStatus());

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<NotFoundResponse>handleToDoItemValidationError(ResourceNotFoundException ex){
		ArrayList details = new ArrayList();
		Message message = new Message(ex.getMessage());
		details.add(message);
		NotFoundResponse notFoundResponse = new NotFoundResponse(details);
		return new ResponseEntity<NotFoundResponse>(notFoundResponse, ex.getStatus());

	}

	//Todo: Validate isComplete data
	@ExceptionHandler(JsonMappingException.class)
	protected ResponseEntity<String>  handleOtherErrors(JsonMappingException ex){
		return new ResponseEntity<String>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}




	private ResponseEntity<ValidationResponse> buildResponseEntity(ValidationResponse validationResponse, HttpStatus status) {
		return new ResponseEntity<>(validationResponse, status);
	}


}
