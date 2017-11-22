package com.puffinpowered.tasktodo.enums;

public enum TaskToDoEnum {

	VALIDATION_ERROR("ValidationError"),
	NOT_FOUND("NotFoundError");

	String value;

	TaskToDoEnum(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
