package com.usermanagement.commons.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.commons.dto.UserDTO;
import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.BaseModel;
import com.usermanagement.commons.model.User;
import com.usermanagement.commons.repository.UserRepository;
import com.usermanagement.commons.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserDTO saveUser(User user) throws UMException, Exception {
		user = userRepository.saveUser(user);
		if (user != null) {
			return user.toDTO(UserDTO.class);
		} else {
			return null;
		}		
	}

	public UserDTO getUserById(Long id) throws UMException, Exception {
		User user = userRepository.getUserById(id);
		if (user != null) {
			return user.toDTO(UserDTO.class);
		} else {
			return null;
		}
	}

	public List<UserDTO> getAllUsers() throws UMException, Exception {
		List<User> listUsers = userRepository.getAllUsers();
		if (listUsers != null && listUsers.size() > 0) {
			return BaseModel.toDTOs(UserDTO.class, listUsers);
		} else {
			return Collections.emptyList();
		}
	}

	public Long deleteUser(Long id) throws UMException {
		return userRepository.deleteUser(id);
	}

	public List<UserDTO> getAllUsersByName(String searchString) throws UMException, Exception {
		List<User> listUsers = userRepository.getAllUsersByName(searchString);
		if (listUsers != null && listUsers.size() > 0) {
			return BaseModel.toDTOs(UserDTO.class, listUsers);
		} else {
			return Collections.emptyList();
		}
	}

	public List<UserDTO> searchUser(UserDTO userDTO) throws UMException, Exception {
		List<User> listUsers = userRepository.searchUser(userDTO);
		if (listUsers != null && listUsers.size() > 0) {
			return BaseModel.toDTOs(UserDTO.class, listUsers);
		} else {
			return Collections.emptyList();
		}
	}

	public List<UserDTO> getUserBySearchString(String searchString) throws UMException, Exception {
		List<User> listUsers = userRepository.getUserBySearchString(searchString);
		if (listUsers != null && listUsers.size() > 0) {
			return BaseModel.toDTOs(UserDTO.class, listUsers);
		} else {
			return Collections.emptyList();
		}
	}

	public UserDTO getUserByName(String firstName, String lastName) throws UMException, Exception {
		User user = userRepository.getUserByName(firstName, lastName);
		if (user != null) {
			return user.toDTO(UserDTO.class);
		} else {
			return null;
		}

	}

	public UserDTO checkEmailExist(String email) throws UMException, Exception {
		User user = userRepository.checkEmailExist(email);
		if (user != null) {
			return user.toDTO(UserDTO.class);
		} else {
			return null;
		}
	}

	public List<UserDTO> getAllUsersByEmail(String searchString) throws UMException, Exception {
		List<User> listUsers = userRepository.getAllUsersByEmail(searchString);
		if (listUsers != null && listUsers.size() > 0) {
			return BaseModel.toDTOs(UserDTO.class, listUsers);
		} else {
			return Collections.emptyList();
		}
	}

}
