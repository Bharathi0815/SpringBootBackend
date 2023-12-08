package org.bharathi.jwtutils;

import org.bharathi.entity.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Component
public class JWTUtils {
	
	
	private static String secret="My-sectet";
	private static  long expiryDuration=3_600_000;
	
	public String generateJwt(UserDetails userdetail)
	{
		
		
		Date issuedAt=new Date();
		Date expirationTime=new Date(issuedAt.getTime()+expiryDuration);
		
		
		
		Claims claims=Jwts.claims()
				.setIssuer(userdetail.getUserId().toString())
				.setIssuedAt(issuedAt)
				.setExpiration(expirationTime);
		         
		
		
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS384, secret)
				.compact();
		
		
	}
	
	
	
	
	

}
