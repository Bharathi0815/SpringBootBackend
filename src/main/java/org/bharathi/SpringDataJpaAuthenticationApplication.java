package org.bharathi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringDataJpaAuthenticationApplication {
	
	
	
	@Bean
	public BCryptPasswordEncoder encoder()
	{
		
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaAuthenticationApplication.class, args);
	}

}
