package com.usermanagement.commons.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.commons.dto.ResponseDTO;
import com.usermanagement.commons.dto.UserDTO;
import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.User;
import com.usermanagement.commons.model.User.Role;
import com.usermanagement.commons.model.User.Status;
import com.usermanagement.commons.service.UserService;
import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/user")
@Api(value = "user", description = "User Operations")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseDTO saveUser(@RequestBody UserDTO userDTO, HttpServletRequest httpRequest) throws UMException, Exception  {
		System.out.println(userDTO.getFirstName() + " " + userDTO.getMiddleName() + " " + userDTO.getLastName());
		System.out.println(userDTO.getEmail() + " " + userDTO.getUserName() + " " + userDTO.getPassword());
		System.out.println(userDTO.getGender());		
		userDTO.setRole(Role.USER);
		userDTO.setStatus(Status.ACTIVE);
		return ResponseDTO.ok(userService.saveUser(userDTO.toModel(User.class)));
	}
	
	@RequestMapping(value="/editUser", method=RequestMethod.GET)
	public ResponseDTO editUser(@RequestParam(value = "id", required = false, defaultValue = "") Long id) throws UMException, Exception{
		return ResponseDTO.ok(userService.getUserById(id));		
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public ResponseDTO deleteUser(@RequestParam(value = "id", required = false, defaultValue = "") Long id) throws UMException,Exception {
		return ResponseDTO.ok(userService.deleteUser(id));
	}

	@RequestMapping(value="/getAllUsers", method=RequestMethod.GET)
	public ResponseDTO getAllUsers() throws UMException,Exception {
		List<UserDTO> listUsers = userService.getAllUsers();
		if (listUsers != null && listUsers.size() > 0) {
			return ResponseDTO.ok(listUsers);
		} else {
			return ResponseDTO.not_found(MSG_USER_NOT_AVIALABLE);
		}
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ResponseDTO searchUser(@RequestBody UserDTO userDTO, HttpServletRequest request) throws UMException ,Exception {
		List<UserDTO> listUsers = userService.searchUser(userDTO);
		if (listUsers != null && listUsers.size() > 0) {
			return ResponseDTO.ok(listUsers);
		} else {
			return ResponseDTO.not_found(MSG_USER_NOT_FOUND);
		}
	}
		
	@RequestMapping(value = "/autoSearch", method = RequestMethod.GET)
	public ResponseDTO autoSearch(@RequestParam(value = "searchString", required = false, defaultValue = "") String searchString) throws UMException ,Exception {
		List<UserDTO> listUsers = userService.getAllUsersByEmail(searchString);
		List<String> emails = new ArrayList<String>();
		if (listUsers != null && listUsers.size() > 0) {
			for (UserDTO userDTO : listUsers) {
				emails.add(userDTO.getEmail());
			}
			if (emails != null && emails.size() > 0) {
				return ResponseDTO.ok(emails);
			} else {
				return ResponseDTO.not_found(MSG_USER_NOT_FOUND);
			}
		} else {
			return ResponseDTO.not_found(MSG_USER_NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/getUserBySearchString", method = RequestMethod.GET)
	public ResponseDTO getUserBySearchString(@RequestParam(value = "searchString", required = false, defaultValue = "") String searchString) throws UMException ,Exception {
		List<UserDTO> listUsers= userService.getUserBySearchString(searchString);
		if (listUsers != null && listUsers.size() > 0) {
			return ResponseDTO.ok(listUsers);
		} else {
			return ResponseDTO.not_found(MSG_USER_NOT_FOUND);
		}
	}

	private static final String MSG_USER_NOT_FOUND = "User Not Found!!!";
	private static final String MSG_USER_NOT_AVIALABLE = "There is not a single user available in records";
}
