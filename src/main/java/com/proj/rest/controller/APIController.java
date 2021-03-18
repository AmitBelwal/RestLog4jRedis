package com.proj.rest.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proj.rest.dao.UserImpl;
import com.proj.rest.modal.User;

@RestController
public class APIController {
	private static Logger LOGGER = LogManager.getLogger(APIController.class);
	
	@Autowired
	private UserImpl dao;
	
	@GetMapping("/users")
	public List<User> getUser() {
		LOGGER.debug(">>>>>>>>Control flow comes in getUser method>>>>>>>>>>" );
		return dao.getUser();
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		LOGGER.debug(">>>>>>>>Control flow comes in createUser method>>>>>>>>>>" );
		User client =  dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(client);
	}
	
	@PutMapping("/users/{userID}")
	public User updateUser(@RequestBody User user, @PathVariable Integer userID) {
		LOGGER.debug(">>>>>>>>Control flow comes in updateUser method>>>>>>>>>>" );
		return dao.updateUser(user, userID);
	}
	@DeleteMapping("/users/{empId}")
	public String deleteUser(@PathVariable Integer userID) {
		LOGGER.debug(">>>>>>>>Control flow comes in deleteUser method>>>>>>>>>>" );
		 dao.deleteUser(userID);
		 return "User Deleted-> "+userID;
	}
	
	@GetMapping("/users/{userID}")
	public User getOneUser(@PathVariable Integer userID) {
		LOGGER.debug(">>>>>>>>Control flow comes in getOneUser method>>>>>>>>>>" );
		return dao.getOneUser(userID);
	}

}
