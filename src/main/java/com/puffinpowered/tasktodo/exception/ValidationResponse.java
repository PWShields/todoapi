package com.puffinpowered.tasktodo.exception;

import com.puffinpowered.tasktodo.enums.TaskToDoEnum;
import com.puffinpowered.tasktodo.exception.Detail;

import java.util.List;

public class ValidationResponse {

	List<Detail> details;

	String name;



	public ValidationResponse(List<Detail> details) {
		this.details = details;
		this.name = TaskToDoEnum.VALIDATION_ERROR.value();
	}


	public ValidationResponse() {
	}

	public List<Detail> getDetails() {
		return details;
	}
	public String getName() {
		return name;
	}

	public void setDetail(List<Detail> details) {
		this.details = details;
	}



}
