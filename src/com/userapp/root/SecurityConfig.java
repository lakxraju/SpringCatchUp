package com.userapp.root;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static Map<String, String> USER_AUTH_MAP; 
	private static Map<String, String> USER_ROLE_MAP; 
	
	static {
		USER_AUTH_MAP = new HashMap<String, String>();
		USER_AUTH_MAP.put("user", "password");
		USER_AUTH_MAP.put("admin", "password");
		
		USER_ROLE_MAP = new HashMap<String, String>();
		USER_AUTH_MAP.put("user", "USER");
		USER_AUTH_MAP.put("admin", "ADMIN");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/**
		USER_AUTH_MAP.entrySet().forEach((entry)->{
			String username = entry.getKey();
			String password = entry.getValue();
			try {
				auth.inMemoryAuthentication()
				.withUser(username).password(encoder().encode(password)).roles(USER_AUTH_MAP.get(username));
			} catch (Exception e) {
				// do nothing
			}
			
		});**/
		
		auth.inMemoryAuthentication()
        .withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN")
        .and()
        .withUser("user").password(encoder().encode("userPass")).roles("USER");

	}
	
	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPasswordEncoder();
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    		http
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/**").hasRole("USER")
            .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
            .and()
            .csrf().disable()
            .formLogin().disable();
    }
	
}
