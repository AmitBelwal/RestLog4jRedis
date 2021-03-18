package com.proj.rest.dao;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.proj.rest.exception.AlreadyExist;
import com.proj.rest.exception.ResourceNotFoundException;
import com.proj.rest.modal.User;
import com.proj.rest.repo.UserRepo;

@Repository
public class UserImpl implements UserDao {
	private static Logger LOGGER = LogManager.getLogger(UserImpl.class);
	@Autowired
	private UserRepo repo;

	@Override
	public User saveUser(User user) {
		LOGGER.debug(">>>>>>>>Control flow comes in updateUser method in user impl >>>>>>>>>>" );
		User optional = repo.findByName(user.getName());
		if (optional.getName().contentEquals(user.getName())) 
			throw new AlreadyExist("Resource Already Exist");
		return repo.save(user);
	}

	@Override
	@CachePut(value = "user", key = "#userID")
	public User updateUser(User user, Integer userID) {
		LOGGER.debug(">>>>>>>>Control flow comes in updateUser method in user impl >>>>>>>>>>" );
		User client = repo.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("Resource does not exist"));
		client.setName(user.getName());
		client.setSal(user.getSal());	
		return client;
	}

	@Override
	@CacheEvict(value = "user", key = "#userID")
	public void deleteUser(Integer userID) {
		LOGGER.debug(">>>>>>>>Control flow comes in updeleteUser method in user impl >>>>>>>>>>" );
		User client = repo.findById(userID)
		.orElseThrow(() -> new ResourceNotFoundException("Resource does not exist"));
		repo.delete(client);
	}

	@Override
	@Cacheable(cacheNames = "UserList")
	public List<User> getUser() {
		LOGGER.debug(">>>>>>>>Control flow comes in getUser method in user impl >>>>>>>>>>" );
		return repo.findAll();
	}

	@Override
	@Cacheable(value = "user", key = "#userID")
	public User getOneUser(Integer userID) {
		LOGGER.debug(">>>>>>>>Control flow comes in getOneUser method in user impl >>>>>>>>>>" );
		User client = repo.findById(userID)
		.orElseThrow(() -> new ResourceNotFoundException("Resource does not exist"));
		return client;
	}
}
