package com.proj.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.rest.modal.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByName(String name);

}
