package com.puffinpowered.tasktodo.controller;

import com.puffinpowered.tasktodo.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<ExceptionResponse> show() throws Exception{
		    ExceptionResponse exceptionResponse = new ExceptionResponse();
		    exceptionResponse.setErrorCode(HttpStatus.OK.value());
		    exceptionResponse.setErrorMessage("Welcome to TaskToDo, please check valid end points");
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.OK);
	}

}
