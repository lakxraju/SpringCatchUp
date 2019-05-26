package com.userapp.repo;

import org.springframework.data.repository.CrudRepository;

import com.userapp.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
