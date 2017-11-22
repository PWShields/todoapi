package com.puffinpowered.tasktodo.service;

import com.puffinpowered.tasktodo.domain.BalanceTestResult;
import com.puffinpowered.tasktodo.exception.ValidationError;

public interface  TaskService {
	BalanceTestResult validateBrackets(String input) throws ValidationError;
}
