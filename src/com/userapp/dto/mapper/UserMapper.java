package com.userapp.dto.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.userapp.dto.UserDTO;
import com.userapp.model.User;

public class UserMapper {
	
	public static UserDTO toDto(User userDO)
    {
		UserDTO userDto = new UserDTO(userDO.getId(), userDO.getFirstName(), userDO.getLastName(), userDO.getCity());
        return userDto;
    }
	
	public static User toEntity(UserDTO user) {
		User userDO = new User();
		userDO.setCity(user.getCity());
		userDO.setFirstName(user.getFirstName());
		userDO.setLastName(user.getLastName());
		return userDO;
	}
	
	
	public static List<UserDTO> toDtos(Collection<User> users) {
		return users.stream().map(UserMapper::toDto).collect(Collectors.toList());
	}
}
