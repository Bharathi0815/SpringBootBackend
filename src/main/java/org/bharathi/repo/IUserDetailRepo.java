package org.bharathi.repo;

import java.util.Optional;

import org.bharathi.dto.LoginRequestDto;

import org.bharathi.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IUserDetailRepo extends JpaRepository<UserDetails, Integer> {
	
	public String getPasswordByName(String name);
	
	public UserDetails getUserDataByName(String name);

}
