package com.springboot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	//JPA Function - Spring do it by Autoconfiguration
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name,String city);
	
	
	//JPA (Hibernate) Querry
	@Query("Select u FROM User u")
	public List<User> getAllUser();
	
	@Query("select u From User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n") String name);

	//SQL Querry
	@Query(value="select * from user",nativeQuery = true)
	public List<User> getUsers();
	
	
}
