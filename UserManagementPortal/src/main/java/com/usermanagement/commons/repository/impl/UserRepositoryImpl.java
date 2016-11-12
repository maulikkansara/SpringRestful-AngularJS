package com.usermanagement.commons.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usermanagement.commons.dto.UserDTO;
import com.usermanagement.commons.exception.UMException;
import com.usermanagement.commons.model.User;
import com.usermanagement.commons.repository.UserRepository;
import com.usermanagement.commons.util.QueryUtil;

@Repository("userRepository")
@SuppressWarnings("unchecked")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public User saveUser(User user) throws UMException {
		if(user.isNew()) {
			user.prePersist();
		} else {
			user.preUpdate();
		}
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
	}

	@Transactional
	public User getUserById(Long id) throws UMException {
		StringBuffer stringbuffer = new StringBuffer("From User Where id=:id");
		List<User> listUserDTO = sessionFactory.getCurrentSession().createQuery(stringbuffer.toString()).setParameter("id", id).list();
		return listUserDTO.get(0);
	}

	@Transactional
	public List<User> getAllUsers() throws UMException {
		StringBuffer stringBuffer = new StringBuffer("From User u");
	    stringBuffer.append(" WHERE "+ QueryUtil.getBaseCause("u")+" AND u.firstName!='Project Enablers'");
		List<User> users = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString()).list();
		return users;
	}

	@Transactional
	public Long deleteUser(Long id) throws UMException {
		User user = getUserById(id);
		user.delete();	
		return id;
	}

	@Transactional
	public List<User> getAllUsersByName(String searchString) throws UMException {
		StringBuffer stringBuffer = new StringBuffer("FROM User u");
		if (searchString != null) {
			stringBuffer.append(" WHERE u.firstName like :firstName  AND u.firstName!='Project Enablers' ");
		}
		stringBuffer.append("ORDER BY u.firstName");
		Query query = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString());
		if (searchString != null) {
			query.setParameter("firstName", searchString + "%");
		}
		List<User> userDTOLists = query.list();
		return userDTOLists;

	}

	@Transactional
	public List<User> searchUser(UserDTO userDTO) throws UMException {
		StringBuffer stringBuffer = new StringBuffer("FROM User u ");
		stringBuffer.append("WHERE "+ QueryUtil.getBaseCause("u") + " AND firstName!='Project Enablers' ");
		
		if (userDTO.getEmail() != null && userDTO.getEmail().trim() != "") {
			stringBuffer.append(" AND UPPER(u.email) = UPPER(:email) ");
		}
		
		stringBuffer.append("ORDER BY u.firstName,u.lastName");
		Query query = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString());
		
		if (userDTO.getEmail() != null && userDTO.getEmail().trim() != "") {
			query.setParameter("email", userDTO.getEmail());	
		}
		List<User> users = query.list();
		return users;
	}

	@Transactional
	public List<User> getUserBySearchString(String searchString) throws UMException {
		StringBuffer stringBuffer = new StringBuffer("FROM User u " );
		stringBuffer.append("WHERE " + QueryUtil.getBaseCause("u") + " AND firstName!='Project Enablers' ");
		stringBuffer.append("ORDER BY u.firstName,u.lastName");
		Query query = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString());
		List<User> userDTOLists = query.list();
		return userDTOLists.size() > 0 ? userDTOLists : null;
	}

	@Transactional
	public User getUserByName(String firstName, String lastName) throws UMException {
		StringBuffer stringBuffer = new StringBuffer("FROM User u WHERE " + QueryUtil.getBaseCause("e") + " AND");
		stringBuffer.append(" u.firstName like :firstName AND u.lastName like :lastName " +" AND firstName!='Project Enablers' ");
		Query query = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString());
		query.setParameter("firstName", firstName + "%");
		query.setParameter("lastName", lastName + "%");
		List<User> userList = query.list();
		User user = null;
		if (userList.size() > 0 && userList != null) {
			user = userList.get(0);
		}
		return user;
	}

	@Transactional
	public User checkEmailExist(String email) throws UMException {
		StringBuffer stringBuffer = new StringBuffer("FROM User u ");
		if (email != null) {
			stringBuffer.append("WHERE u.email=:email ");
		}
		stringBuffer.append("ORDER BY u.email");
		Query query = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString()).setParameter("email", email);
		List<User> userList = query.list();
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public List<User> getAllUsersByEmail(String searchString) throws UMException {
		StringBuffer stringBuffer = new StringBuffer("FROM User u ");
		stringBuffer.append("WHERE " + QueryUtil.getBaseCause("u") + " AND firstName!='Project Enablers' ");
		if (searchString != null) {
			stringBuffer.append(" AND u.email like :email ");
		}
		stringBuffer.append("ORDER BY u.email");
		Query query = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString());
		if (searchString != null) {
			query.setParameter("email", searchString + "%");
		}
		List<User> userLists = query.list();
		return userLists;
	}
	
}
