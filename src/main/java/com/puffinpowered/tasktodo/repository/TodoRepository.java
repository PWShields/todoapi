package com.puffinpowered.tasktodo.repository;

import com.puffinpowered.tasktodo.domain.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
