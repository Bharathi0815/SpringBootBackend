package org.bharathi.apiresponse;

import org.bharathi.entity.UserDetails;

import lombok.Data;

@Data
public class APIResponse {
	
	
	private String token;
	private UserDetails userDetails;
	
	public APIResponse(String token, UserDetails userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }
	
	

}
