package com.puffinpowered.tasktodo.service;

import com.puffinpowered.tasktodo.domain.BalanceTestResult;
import com.puffinpowered.tasktodo.exception.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

	private ValidationService validationService;

	@Autowired
	public TaskServiceImpl(ValidationService validationService) {
		this.validationService = validationService;
	}

	@Override
	public BalanceTestResult validateBrackets(String input) throws ValidationError {

		BalanceTestResult response = new BalanceTestResult();
		Boolean isInputValid = validationService.validate(input);
		if (isInputValid == Boolean.FALSE) {
			throw validationService.buildValidationError(input, "input");
		} else {
			response.setInput(input);
			response.setIsBalanced(validationService.checkBrackets(input));
		}
		return response;
	}





}
