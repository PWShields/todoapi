package com.puffinpowered.tasktodo.exception;

import com.puffinpowered.tasktodo.enums.TaskToDoEnum;

import java.util.List;

public class NotFoundResponse {

	List<Message> details;

	String name;



	public NotFoundResponse(List<Message> details) {
		this.details = details;
		this.name = TaskToDoEnum.NOT_FOUND.value();
	}


	public NotFoundResponse() {
	}

	public List<Message> getDetails() {
		return details;
	}
	public String getName() {
		return name;
	}

	public void setDetail(List<Message> details) {
		this.details = details;
	}



}
