package org.bharathi.service;

import org.bharathi.dto.LoginRequestDto;
import org.bharathi.entity.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserService extends UserDetailsService {
	public String registerUser(UserDetails detail);
	
	public UserDetails authenticateUser(LoginRequestDto loginrequestdto);
	
	

}
