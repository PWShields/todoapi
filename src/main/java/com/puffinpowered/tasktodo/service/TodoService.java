package com.puffinpowered.tasktodo.service;

import com.puffinpowered.tasktodo.domain.Todo;

public interface TodoService {
	Todo createItem(Todo input);

	Todo fetchItem(Long input);

	Todo updateItem(Long id, Todo newDetails);
}
