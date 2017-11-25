package com.puffinpowered.tasktodo.service;

import com.puffinpowered.tasktodo.exception.ValidationError;

public interface ValidationService {

	ValidationError buildValidationError(String input, String text);

	Boolean validateText(String input);

	Boolean checkBrackets(String input);

	Boolean validateIsComplete(Boolean isCompleted);
}
