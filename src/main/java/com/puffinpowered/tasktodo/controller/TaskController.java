package com.puffinpowered.tasktodo.controller;

import com.puffinpowered.tasktodo.domain.BalanceTestResult;
import com.puffinpowered.tasktodo.exception.ValidationError;
import com.puffinpowered.tasktodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	/**
	 * We are using requestParam to match the sample API, favour a more restful approach
	 * with path variables where possible.
	 *
	 * The sample API defines the response required for a successful and an unsuccessful request
	 *
	 * @param input - a string of between 1 and 50 characters
	 * @return   either a ResponseEntity or a ValidationResponse as JSON objects
	 * @throws ValidationError
	 */
	@RequestMapping(value="/validateBrackets", method=RequestMethod.GET)
	public ResponseEntity<BalanceTestResult> validateBrackets(@RequestParam(value = "input", defaultValue = "") String input) throws ValidationError {
		   BalanceTestResult balanceTestResult = taskService.validateBrackets(input) ;
		  return new ResponseEntity<BalanceTestResult>(balanceTestResult, HttpStatus.OK);
	}
}
