package com.userapp.root;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.userapp.model.User;
import com.userapp.repo.UserRepository;

@EnableJpaRepositories("com.userapp.repo")
@EntityScan(basePackages = {"com.userapp.model"})
@SpringBootApplication
public class UserApplication {
	
	@Autowired
	UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	User user1 = new User();
	    	user1.setFirstName("test_user_firstName");
	    	user1.setLastName("test_user_lastName");
	    	user1.setCity("test_user_city");
	    	
	    	User user2 = new User();
	    	user2.setFirstName("test_user2_firstName");
	    	user2.setLastName("test_user2_lastName");
	    	user2.setCity("test_user2_city");
	    	
	    	User user3 = new User();
	    	user3.setFirstName("test_user3_firstName");
	    	user3.setLastName("test_user3_lastName");
	    	user3.setCity("test_user3_city");
	    	
	    	userRepo.save(user1);
	    	userRepo.save(user2);
	    	userRepo.save(user3);
	      };
	}
}
