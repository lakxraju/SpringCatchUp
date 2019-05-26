package com.userapp.root;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userapp.dto.UserDTO;
import com.userapp.dto.mapper.UserMapper;
import com.userapp.model.User;
import com.userapp.service.UserService;


@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	UserService userService;
	
	@Autowired
    public UserController(final UserService userService)
    {
        this.userService = userService;
    }

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		return new ResponseEntity<>(UserMapper.toDtos(userService.getAllUsers()), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO user){
		User userDO = UserMapper.toEntity(user);
		userService.update(userDO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
