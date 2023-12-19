package org.bharathi.controller;



import java.util.List;

import org.bharathi.dto.TodoDto;

import org.bharathi.entity.TodoDetails;
import org.bharathi.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo")
public class TodoController {
	
	
	@Autowired
	ITodoService service;
	
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllTodos()
	{
		
		
		try
		{
			List <TodoDetails> list=service.getAllDetails();
			return new ResponseEntity<List<TodoDetails>>(list,HttpStatus.OK);
			
		}catch(Exception e)
		{
			
			return new ResponseEntity<String>("Data is not avilable",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addTodo(@RequestBody TodoDetails todo)
	{
		
		System.out.println("controll entered");
		System.out.println(todo);
		
		try
		{
			TodoDetails td=service.saveTodo(todo);
			return new ResponseEntity<TodoDetails>(td,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("problem occured in server",HttpStatus.INTERNAL_SERVER_ERROR)	;	
		}
	}
	
	
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteTodo(@RequestBody TodoDetails todo)
	{
		System.out.println(todo);
	
		
		try
		{	
			
			
			System.out.println("inside controller method");
			
		String msg=	service.deleteTodoRecord(todo);
			
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		
		catch(Exception e)
		{
			return new ResponseEntity<String>("problem occured in server",HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	
	
	
	  @PostMapping("/update")
	  public ResponseEntity<?> editTodo(@RequestBody TodoDetails todo)
	  {
		  System.out.println("Edit method"+todo);
		  
		  try
		  {
			  TodoDetails todoDetail=service.updateTodo(todo);
			  
			  return new ResponseEntity<TodoDetails>(todoDetail,HttpStatus.OK);
			  
		  }catch(Exception e)
		  {
			  return new ResponseEntity<String>("problem occured in server",HttpStatus.INTERNAL_SERVER_ERROR);
			  
           }
		 	  
		 
	  }	

}
