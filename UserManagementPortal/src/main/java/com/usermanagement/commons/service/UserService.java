package com.usermanagement.commons.service;

import java.util.List;

import com.usermanagement.commons.dto.UserDTO;
import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.User;

public interface UserService {
	public UserDTO saveUser(User user) throws UMException, Exception;

	public UserDTO getUserById(Long id) throws UMException, Exception;

	public List<UserDTO> getAllUsers() throws UMException, Exception;

	public Long deleteUser(Long id) throws UMException;

	public List<UserDTO> getAllUsersByName(String searchString) throws UMException, Exception;

	public List<UserDTO> searchUser(UserDTO userDTO) throws UMException, Exception;

	public List<UserDTO> getUserBySearchString(String searchString) throws UMException, Exception;

	public UserDTO getUserByName(String firstName, String lastName) throws UMException, Exception;

	public UserDTO checkEmailExist(String email) throws UMException, Exception;

	public List<UserDTO> getAllUsersByEmail(String searchString) throws UMException, Exception;

}
