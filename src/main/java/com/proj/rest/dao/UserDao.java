package com.proj.rest.dao;

import java.util.List;

import com.proj.rest.modal.User;

public interface UserDao {
	public User saveUser(User user);
	public User updateUser(User user, Integer userID);
	public void deleteUser(Integer userID);
	public List<User> getUser();
	public User getOneUser(Integer userID);

}