package org.bharathi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	
	@Bean
    public  SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/user/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin();
		return http.build();

        // Add filter to handle JWT authentication
       // http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
        //http.addFilter(new JwtAuthorizationFilter(authenticationManager()));
    }

}
