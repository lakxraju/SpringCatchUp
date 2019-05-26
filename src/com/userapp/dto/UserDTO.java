package com.userapp.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	
	@JsonIgnore
	private Long id;
	
	@NotNull(message = "First Name cannot be null")
	private String firstName;
	
	@NotNull(message = "Last Name cannot be null")
	private String lastName;
	
	@NotNull(message = "City cannot be null")
	private String city;
	
	public UserDTO(Long id, String firstName, String lastName, String city) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	
	public UserDTO() {
		
	}

	@JsonProperty
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}
	
}
