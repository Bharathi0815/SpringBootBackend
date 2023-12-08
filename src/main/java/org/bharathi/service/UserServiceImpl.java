package org.bharathi.service;

import java.util.Optional;

import org.bharathi.dto.LoginRequestDto;
import org.bharathi.repo.IUserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements IUserService{
	
	@Autowired
	IUserDetailRepo repo;
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;

     //String storedPassword=null;

	@Override
	public String registerUser(org.bharathi.entity.UserDetails user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		repo.save(user);
		return "User Saved";
	}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public org.bharathi.entity.UserDetails authenticateUser(LoginRequestDto loginrequestdto) {
	
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder ();
	
	String enteredName=loginrequestdto.getName();
	String enteredPassword=loginrequestdto.getPassword();
	
	System.out.println("entered name"+enteredName);
	System.out.println("entered name"+enteredPassword);

	
	
	org.bharathi.entity.UserDetails userData=repo.getUserDataByName(enteredName);
	
				
		
		
		

		    if (userData != null) {
		    	
		    	String storedEncryptedPassword = userData.getPassword();
		       
		    	System.out.println("stored password"+storedEncryptedPassword);
		    	
		    	

		    //	System.out.println("enteredEncryptedPassword"+enteredEncryptedPassword);
		        

				if (bcrypt.matches(loginrequestdto.getPassword(),userData.getPassword())) {
	                return userData; // Authentication successful; return user details
	            }
		    }

		    
		    return null;
}




}
