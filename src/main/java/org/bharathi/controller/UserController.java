package org.bharathi.controller;


import org.bharathi.dto.LoginRequestDto;
import org.springframework.web.client.RestTemplate;
import org.bharathi.entity.UserDetails;

import org.bharathi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	IUserService service;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<String> saveRecord(@RequestBody UserDetails user)
	{
    	String name=user.getName();
    	user.setName(name.replaceAll("\\s+", ""));
		try
		{
		String msg=service.registerUser(user);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("problem occured in server",HttpStatus.INTERNAL_SERVER_ERROR)	;	
		}
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?>  signIn(@RequestBody LoginRequestDto loginrequestdto)
	{
		
		      String name=loginrequestdto.getName();
		      System.out.println(name);
		       String password=loginrequestdto.getPassword();
		       System.out.println(password);
		
		      try
		      {
	         UserDetails response=service.authenticateUser(loginrequestdto);
	         if(response!=null)
	         {
	         
		      return new ResponseEntity<UserDetails>(response,HttpStatus.OK);
				
	         }
	         else 
	         {
	        	 return new ResponseEntity<String>("Invalid User or password",HttpStatus.BAD_REQUEST);
	         }
	
		      }catch(Exception e)
		      {
		    	  return new ResponseEntity<String>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
		      }

}
}
