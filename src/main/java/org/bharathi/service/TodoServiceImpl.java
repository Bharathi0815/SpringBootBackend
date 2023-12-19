package org.bharathi.service;

import java.util.List;

import org.bharathi.entity.TodoDetails;
import org.bharathi.repo.ITodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements ITodoService

{
	
	@Autowired
	ITodoRepo repo;
	
	

	@Override
	public TodoDetails saveTodo(TodoDetails todo)
	{
			
		repo.save(todo);
		return todo;
	}

	
	
	@Override
	public String deleteTodoRecord(TodoDetails todo)
	{
		System.out.println("inside service impl method");
		System.out.println(todo);
		
		if(repo.existsById(todo.getId()))
			
		{
			
			System.out.println("got the record");
			
			repo.deleteById(todo.getId());
			return "Data deleted";
		}
		
		else
			
			return "Data is not deleted";
		
		
	}

	@Override
	public TodoDetails updateTodo(TodoDetails todo)
	{
		
		if(repo.existsById(todo.getId()))
			repo.save(todo);		
			return todo;			
		
	}

	@Override
	public List<TodoDetails> getAllDetails()
	{
			
	List<TodoDetails> list=	repo.findAll();
		
		return list;
	}	

}
