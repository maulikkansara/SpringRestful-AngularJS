package com.usermanagement.commons.repository;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.usermanagement.commons.dto.UserDTO;
import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "UserManagementPortal-servlet.xml" })
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;

	public UserRepositoryTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testSaveUser() {
		/*User user = new User();
		user.setFirstName("Mahesh");
		user.setLastName("Modi");
		user.setUserName("mahesh.modi");
		user.setPassword("saibaba");
		user.setEmail("mahesh.modi@gmail.com");
		user.setBirthDate(new Timestamp(System.currentTimeMillis()));
		user.setContactNo1(9925517709L);		
		user.setRole(Role.ADMIN);
		user.setStatus(Status.ACTIVE);
		user.setGender(Gender.MALE);*/
		UserDTO user = new UserDTO();		
		try {
			List<User> users = userRepository.searchUser(user);
			System.out.println("User added successfully ++ " + users.size());
		} catch (UMException umException) {
			umException.printStackTrace();
		}
	
	}
}
