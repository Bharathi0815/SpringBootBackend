package org.bharathi.service;

import java.util.List;

import org.bharathi.entity.TodoDetails;
import org.bharathi.repo.ITodoRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoService  {
	
	
	public TodoDetails saveTodo(TodoDetails todo);
	public String deleteTodoRecord(TodoDetails todo );
	public TodoDetails updateTodo(TodoDetails todo);
	public List<TodoDetails> getAllDetails();

}
