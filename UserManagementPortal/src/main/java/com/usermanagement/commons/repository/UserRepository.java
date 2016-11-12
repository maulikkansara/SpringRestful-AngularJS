package com.usermanagement.commons.repository;

import java.util.List;

import com.usermanagement.commons.dto.UserDTO;
import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.User;

public interface UserRepository {

	public User saveUser(User user) throws UMException;

	public User getUserById(Long id) throws UMException;

	public List<User> getAllUsers() throws UMException;

	public Long deleteUser(Long id) throws UMException;

	public List<User> getAllUsersByName(String searchString) throws UMException;

	public List<User> searchUser(UserDTO userDTO) throws UMException;

	public List<User> getUserBySearchString(String searchString) throws UMException;
	
	public User getUserByName(String firstName, String lastName) throws UMException;
	
	public User checkEmailExist(String email) throws UMException;
	
	public List<User> getAllUsersByEmail(String searchString) throws UMException;
	
}
