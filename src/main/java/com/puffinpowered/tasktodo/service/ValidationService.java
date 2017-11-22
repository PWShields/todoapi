package com.puffinpowered.tasktodo.service;

import com.puffinpowered.tasktodo.exception.ValidationError;

public interface ValidationService {

	ValidationError buildValidationError(String input, String text);

	Boolean validate(String input);

	Boolean checkBrackets(String input);
}
